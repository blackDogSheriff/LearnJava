# Annotation

---

## @Configuration

- `@Configuration`注解标识的类重声明了一个或者多个`@Bean`方法，Spring容器可以使用这些方法来注入Bean;

```java
@Configuration
public class AppConfig {
  //这个方法就向Spring容器注入了一个类型是MyBean名字是myBean的Bean
  @Bean
  public MyBean myBean() {
     // instantiate, configure and return bean ...
  }
}
```

- `@Configuration`类一般是由`AnnotationConfigApplicationContext`或者它的web变种`AnnotationConfigWebApplicationContext`来处理的；

```java
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//这是configuration类
ctx.register(AppConfig.class);
ctx.refresh();
MyBean myBean = ctx.getBean(MyBean.class);
// use myBean ...
```

- 也可以使用xml方式引用，就和引入普通的Bean一样的：

```xml
<beans>
  <context:annotation-config/>
  <!--也可以这样加载configuration类-->
  <bean class="com.acme.AppConfig"/>
</beans>
```

## @EnableAutoConfiguration

参考uri：`https://www.jianshu.com/p/464d04c36fb1`

根据jar包中的`META-INF/spring.factories`文件中配置，自动加载jar包中的bean；

```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=core.bean.MyConfig
```

- key：为自定配置类`EnableAutoConfiguration`的全路径
- value：为jar包中定义Bean配置类的全路径

## @Configuration和@Component的区别

`@Configuration`本质上还是还是`@Component`，因此`<context:component-scan/>`或者`@ComponentScan`都能处理`@Configuration`注解的类：

- 配置类必须以类的形式提供，允许通过生成子类在运行时增强；
- 配置类不是final类，没有办法动态管理；
- 配置注解通常是为了通过`@Bean`注解生成Spring容器管理类;
- `@Bean`方法可能不会反过来创建进一步的配置类，也就是返回的Bean如果带有`@Configuration`也不会特殊处理，而是视作普通的Bean；
