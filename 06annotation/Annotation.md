# Annotation

---

## 使用Annotation

## 定义Annotation

使用`@interface`定义Annotation：

### 元注解

#### @Target

修饰位置：

- 类或接口：ElementType.TYPE；
- 字段：ElementType.FIELD；
- 方法：ElementType.METHOD；
- 构造方法：ElementType.CONSTRUCTOR；
- 方法参数：ElementType.PARAMETER。

#### @Retention

修饰生命周期

- 仅编译期：RetentionPolicy.SOURCE；
- 仅class文件：RetentionPolicy.CLASS；
- 运行期：RetentionPolicy.RUNTIME。

#### @Repeatable

修饰是否可重复

#### @Inherited

修饰子类是否可以继承父类的`Annotation`，`@Inherited`仅针对`@Target(ElementType.TYPE)`类型的注解有效，并且仅针对于class继承，对interface无效；

## 处理Annotation
