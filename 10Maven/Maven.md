# Maven

---

## Maven介绍

Maven的作用：

- **依赖管理**：将**依赖的jar包**添加到`classpath`中；
- **环境配置**：JDK版本、编译打包流程、当前代码的版本号；
- **确定项目目录结构**：src存放源码、resource存放配置文件、bin存放编译生成的.class文件；
- **流程确定**：提供一套标准的构建流程（编译、测试、打包、发布）

### Maven项目结构

> a-maven-project
> ├── pom.xml
> ├── src
> │   ├── main
> │   │   ├── java
> │   │   └── resources
> │   └── test
> │       ├── java
> │       └── resources
> └── target

- **a-maven-project**：项目名
- **src/main/java**：源码目录
- **src/main/resources**：资源文件
- **src/test/java**：测试文件

### 配置文件结构

```xml
<project ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.itranswarp.learnjava</groupId>
    <artifactId>hello</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>
    <properties>
           ...
    </properties>
    <dependencies>
           <dependency>
               <groupId>commons-logging</groupId>
               <artifactId>commons-logging</artifactId>
               <version>1.2</version>
           </dependency>
    </dependencies>
</project>
```

- gourpId：java包名
- artifactId：java类名
- version：版本号

使用dependency声明一个依赖项之后，Maven就会自动下载这个依赖包，并将其放到classpath中；

### 依赖管理

- Maven的第一个作用就是解决依赖管理。我们声明了自己的项目需要abc，Maven会自动导入abc的jar包，再判断出abc需要xyz，又会自动导入xyz的jar包，这样，最终我们的项目会依赖abc和xyz两个jar包

  - 声明一个`spring-boot-starter-web`依赖时，Maven会自动解析并判断最终大概需要二三十个其它依赖：

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>1.4.2.RELEASE</version>
    </dependency>
    ```

    ```bash
    spring-boot-starter-web
    spring-boot-starter
        spring-boot
        sprint-boot-autoconfigure
        spring-boot-starter-logging
        logback-classic
            logback-core
            slf4j-api
        jcl-over-slf4j
            slf4j-api
        jul-to-slf4j
            slf4j-api
        log4j-over-slf4j
            slf4j-api
        spring-core
        snakeyaml
    spring-boot-starter-tomcat
        tomcat-embed-core
        tomcat-embed-el
        tomcat-embed-websocket
        tomcat-embed-core
    jackson-databind
    ...
    ```

#### 依赖关系

Maven定义了几种依赖关系，分别是`compile`、`test`、`runtime`和`provided`：

|scope|说明|示例|
|---|---|---|
|compile|编译时需要用到该jar包（默认）|commons-logging|
|test|编译Test时需要用到该jar包|junit|
|runtime|编译时不需要，但运行时需要用到|mysql|
|provided|编译时需要用到，但运行时由JDK或某个服务器提供|servlet-api|

- `test`：仅仅在测试的时候需要使用，正常运行的时候不需要，最长用的test就是JUnit：

    ```xml
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.3.2</version>
        <scope>test</scope>
    </dependency>
    ```

- `runtime`：表示编译时不需要，但运行时需要。最典型的runtime依赖是JDBC驱动，例如MySQL驱动：

    ```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.48</version>
        <scope>runtime</scope>
    </dependency>
    ```

- `provided`：表示编译时需要，但运行时不需要。最典型的provided依赖是Servlet API，编译的时候需要，但是运行时，Servlet服务器内置了相关的jar，所以运行期不需要：

    ```xml
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.0</version>
        <scope>provided</scope>
    </dependency>
    ```

#### 依赖下载

- Maven维护了一个中央仓库（repo1.maven.org），所有第三方库将自身的jar以及相关信息上传至中央仓库，Maven就可以从中央仓库把所需依赖下载到本地；
- Maven并不会每次都从中央仓库下载jar包。一个jar包一旦被下载过，就会被Maven自动缓存在本地目录（用户主目录的.m2目录），所以，除了第一次编译时因为下载需要时间会比较慢，后续过程因为有本地缓存，并不会重复下载相同的jar包；

#### 依赖唯一性

对于某个依赖，Maven只需要3个变量即可唯一确定某个jar包：

- groupId：属于组织的名称，类似Java的包名；
- artifactId：该jar包自身的名称，类似Java的类名；
- version：该jar包的版本。
通过上述3个变量，即可唯一确定某个jar包。Maven通过对jar包进行PGP签名确保任何一个jar包一经发布就无法修改。修改已发布jar包的唯一方法是发布一个新版本。

因此，某个jar包一旦被Maven下载过，即可永久地安全缓存在本地。
`-SNAPSHOT`结尾的版本号会被Maven视为开发版本，开发版本每次都会重复下载，这种SNAPSHOT版本只能用于内部私有的Maven repo，公开发布的版本不允许出现SNAPSHOT。

#### 搜索第三方依赖

在`search.maven.org`中搜索，然后直接复制;

#### 命令行编译

```bash
mvn clean package
```

## 构建流程

Maven不但有标准化的项目结构，而且还有一套标准化的构建流程，可以自动化实现编译，打包，发布，等等。

### Lifecycle和Phase

- Maven的**生命周期**由一系列阶段（`phase`）构成，以内置的生命周期default为例，它包含以下phase：

  - validate
  - initialize
  - generate-sources
  - process-sources
  - generate-resources
  - process-resources
  - compile
  - process-classes
  - generate-test-sources
  - process-test-sources
  - generate-test-resources
  - process-test-resources
  - test-compile
  - process-test-classes
  - test
  - prepare-package
  - package
  - pre-integration-test
  - integration-test
  - post-integration-test
  - verify
  - install
  - deploy

- 如果我们运行mvn package，Maven就会执行default生命周期，它会从开始一直运行到package这个phase为止：

  - validate
  - ...
  - package
- 如果我们运行mvn compile，Maven也会执行default生命周期，但这次它只会运行到compile，即以下几个phase：

  - validate
  - ...
  - compile
- Maven另一个常用的生命周期是clean，它会执行3个phase：

  - pre-clean
  - clean （注意这个clean不是lifecycle而是phase）
  - post-clean

- 常用的命令：
  - `mvn clean`：清理所有生成的class和jar；
  - `mvn clean compile`：先清理，再执行到compile；
  - `mvn clean test`：先清理，再执行到test，因为执行test前必须执行compile，所以这里不必指定compile；
  - `mvn clean package`：先清理，再执行到package

- 常用的parse：
  - clean：清理
  - compile：编译
  - test：运行测试
  - package：打包

### Goal

执行一个phase又会触发一个或多个goal：

|执行的Phase|对应执行的Goal|
|---|---|
|compile|compiler:compile|test|
|compiler:testCompile|surefire:test|

## 使用插件

使用Maven构建项目就是执行lifecycle，执行到指定的phase为止。每个phase会执行自己默认的一个或多个goal。goal是最小任务单元。

我们以compile这个phase为例，如果执行：

```bash
mvn compile
```

Maven将执行compile这个phase，这个phase会调用compiler插件执行关联的compiler:compile这个goal。

实际上，执行每个phase，都是通过某个插件（plugin）来执行的，Maven本身其实并不知道如何执行compile，它只是负责找到对应的compiler插件，然后执行默认的compiler:compile这个goal来完成编译。

所以，使用Maven，实际上就是配置好需要使用的插件，然后通过phase调用它们。

- Maven已经内置了一些常用的标准插件：

|插件名称|对应执行的phase|
|---|---|
|clean|clean|
|compiler|compile|
|surefire|test|
|jar|package|

### 使用自定义插件

如果标准插件无法满足需求，我们还可以使用自定义插件。使用自定义插件的时候，需要声明。例如，使用maven-shade-plugin可以创建一个可执行的jar，要使用这个插件，需要在pom.xml中声明它：

```xml
<project>
 <build>
  <plugins>
   <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.1</version>
    <executions>
     <execution>
      <phase>package</phase>
      <goals>
       <goal>shade</goal>
      </goals>
      <configuration>
      </configuration>
     </execution>
    </executions>
   </plugin>
  </plugins>
 </build>
</project>
```

自定义插件往往需要一些配置，例如，maven-shade-plugin需要指定Java程序的入口，它的配置是：

```xml
<configuration>
    <transformers>
        <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
            <mainClass>com.itranswarp.learnjava.Main</mainClass>
        </transformer>
    </transformers>
</configuration>
```
