# SpringBoot

---

## 配置文件

### SpringBoot配置文件

SpringBoot的默认配置文件是`yml`格式，而不是`.properties`格式，**文件名必须是`application.properties`**；

- `application.yml`

```yml
# application.yml

spring:
  application:
    name: ${APP_NAME:unnamed}
  datasource:
    url: jdbc:hsqldb:file:testdb
    username: sa
    password:
    driver-class-name: org.hsqldb.jdbc.JDBCDriver
    hikari:
      auto-commit: false
      connection-timeout: 3000
      validation-timeout: 3000
      max-lifetime: 60000
      maximum-pool-size: 20
      minimum-idle: 1
```

- `${APP_NAME:unnamed}`：的意思是有环境变量优先使用环境变量，没有则使用默认值；

### 日志配置文件

- logback.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/defaults.xml" />

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
            <charset>utf8</charset>
        </encoder>
    </appender>

    <appender name="APP_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
            <charset>utf8</charset>
        </encoder>
          <file>app.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.FixedWindowRollingPolicy">
            <maxIndex>1</maxIndex>
            <fileNamePattern>app.log.%i</fileNamePattern>
        </rollingPolicy>
        <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
            <MaxFileSize>1MB</MaxFileSize>
        </triggeringPolicy>
    </appender>

    <root level="INFO">
        <appender-ref ref="CONSOLE" />
        <appender-ref ref="APP_LOG" />
    </root>
</configuration>
```

- 通过`<include resource="org/springframework/boot/logging/logback/defaults.xml" />`引入了SpringBoot的缺省配置，这样我们可以引用`${CONSOLE_LOG_PATTERN}`这种变量来定义日志格式

## 目录结构

```txt
springboot-hello
├── pom.xml
├── src
│   └── main
│       ├── java
│       └── resources
│           ├── application.yml
│           ├── logback-spring.xml
│           ├── static
│           └── templates
└── target
```

- static是静态文件目录，templates是模板文件目录，注意它们不再存放在src/main/webapp下，而是直接放到src/main/resources这个classpath目录，因为在Spring Boot中已经不需要专门的webapp目录了

```txt
src/main/java
└── com
    └── itranswarp
        └── learnjava
            ├── Application.java
            ├── entity
            │   └── User.java
            ├── service
            │   └── UserService.java
            └── web
                └── UserController.java
```

- Spring Boot要求main()方法所在的启动类必须放到根package下，命名不做要求

## 启动SpringBoot应用程序

启动SpringBoot应用程序只需要再一行代码上加一个注解：`@SpringBootApplication`：

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
```

`@SpringBootApplication`实际包含了：

- `@SpringBootConfiguration`：配置注解，底层实际也是`@Configuration`，只不过在SpringBoot工程中更推荐使用`@SpringBootConfiguration`注解；
  - `@Configuration`：可以理解成一个Spring的xml版容器（存放Beans）
- `@EnableAutoConfiguration`：启动**自动配置**，根据所依赖的jar包自动配置相关配置项（使用jar中创建的Bean）；
  - `@AutoConfigurationPackage`
- `@ComponentScan`：**自动扫描**配置，SpringBoot默认会自动扫描启动类所在的同级包以及子级包；

## pom.xml引用

```xml
<project ...>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.0</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.itranswarp.learnjava</groupId>
    <artifactId>springboot-hello</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <java.version>17</java.version>
        <pebble.version>3.2.0</pebble.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>

        <!-- 集成Pebble View -->
        <dependency>
            <groupId>io.pebbletemplates</groupId>
            <artifactId>pebble-spring-boot-starter</artifactId>
            <version>${pebble.version}</version>
        </dependency>

        <!-- JDBC驱动 -->
        <dependency>
            <groupId>org.hsqldb</groupId>
            <artifactId>hsqldb</artifactId>
        </dependency>
    </dependencies>
</project>
```

### AutoConfiguration

spring-boot启动时会自动扫描`pom.xml`引入jar包中的所有的`xxxAutoConfiguration`：

- 引入`spring-boot-starter-jdbc`时，自动扫描以下配置：
  - `DataSourceAutoConfiguration`：自动创建一个`DataSource`，其中配置项从`application.yml`的`spring.datasource`读取；
  - `DataSourceTransactionManagerAutoConfiguration`：自动创建了一个基于JDBC的事务管理器`DataSourceTransactionManager`；
  - `JdbcTemplateAutoConfiguration`：自动创建了一个JdbcTemplate。

- 引入`spring-boot-starter-web`时，自动扫描：
  - `ServletWebServerFactoryAutoConfiguration`：自动创建一个嵌入式Web服务器，默认是Tomcat；
  - `DispatcherServletAutoConfiguration`：自动创建一个DispatcherServlet；
  - `HttpEncodingAutoConfiguration`：自动创建一个CharacterEncodingFilter；
  - `WebMvcAutoConfiguration`：自动创建若干与MVC相关的Bean。

- 引入`pebble-spring-boot-starter`时，自动扫描：
- `PebbleAutoConfiguration`：自动创建了一个`PebbleViewResolver`。

- `JdbcTemplateAutoConfiguration`

**JdbcTemplateAutoConfiguration**示例：

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({ DataSource.class, JdbcTemplate.class })
@ConditionalOnSingleCandidate(DataSource.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(JdbcProperties.class)
@Import({ JdbcTemplateConfiguration.class, NamedParameterJdbcTemplateConfiguration.class })
public class JdbcTemplateAutoConfiguration {
}
```

当满足条件：

- `@ConditionalOnClass`：在classpath中能找到DataSource和JdbcTemplate；
- `@ConditionalOnSingleCandidate(DataSource.class)`：在当前Bean的定义中能找到唯一的DataSource；

该`JdbcTemplateAutoConfiguration`就会起作用，实际创建由导入的`JdbcTemplateConfiguration`完成：

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingBean(JdbcOperations.class)
class JdbcTemplateConfiguration {
    @Bean
    @Primary
    JdbcTemplate jdbcTemplate(DataSource dataSource, JdbcProperties properties) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        JdbcProperties.Template template = properties.getTemplate();
        jdbcTemplate.setFetchSize(template.getFetchSize());
        jdbcTemplate.setMaxRows(template.getMaxRows());
        if (template.getQueryTimeout() != null) {
            jdbcTemplate.setQueryTimeout((int) template.getQueryTimeout().getSeconds());
        }
        return jdbcTemplate;
    }
}
```

## Conditionnal

使用Profile能根据不同的Profile进行条件装配，但是Profile控制比较粗糙，如果想要精细控制，用Profile比较难以实现；
Spring本身提供了条件装配的@Conditional，但是要自己编写比较复杂的Condition来做判断，比较麻烦，SpringBoot提供了几个有用的条件：

- @ConditionalOnProperty：如果有指定的配置，条件生效；
- @ConditionalOnBean：如果有指定的Bean，条件生效；
- @ConditionalOnMissingBean：如果没有指定的Bean，条件生效；
- @ConditionalOnMissingClass：如果没有指定的Class，条件生效；
- @ConditionalOnWebApplication：在Web环境中条件生效；
- @ConditionalOnExpression：根据表达式判断条件是否生效。

## 加载配置文件

加载配置文件可以直接使用注解`@Value`，例如我们定义了一个最大允许上传的配置：

```yml
storage:
  local:
    max-size: 102400
```

在某个FileUploader里需要获取该配置，可使用`@Value`注入：

```java
@Component
public class FileUploader {
    @Value("${storage.local.max-size:102400}")
    int maxSize;

    ...
}
```

在另一个UploadFilter中，因为要检查文件的MD5，也需要该配置：

```java
@Component
public class UploadFilter implements Filter {
    @Value("${storage.local.max-size:100000}")
    int maxSize;
    ...
}
```

多次引用一个`@Value`不但麻烦，而且`@Value`使用字符串，缺少编译器检查，容易造成多处引用不一致；
为了更好的配置管理，SpringBoot允许创建一个Bean，持有一组配置，并且由SpringBoot自动注入：

加入有一组配置如下：

```bash
storage:
  local:
    # 文件存储根目录:
    root-dir: ${STORAGE_LOCAL_ROOT:/var/storage}
    # 最大文件大小，默认100K:
    max-size: ${STORAGE_LOCAL_MAX_SIZE:102400}
    # 是否允许空文件:
    allow-empty: false
    # 允许的文件类型:
    allow-types: jpg, png, gif
```

首先定义一个Java Bean持有该组配置：

```java
public class StorageConfiguration {

    private String rootDir;
    private int maxSize;
    private boolean allowEmpty;
    private List<String> allowTypes;

    // TODO: getters and setters
}
```

保证Java Bean的属性名称与配置一致即可，然后我们添加两个注解：

```java
@Configuration
@ConfigurationProperties("storage.local")
public class StorageConfiguration {
    ...
}
```
