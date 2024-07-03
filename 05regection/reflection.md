# reflection

---

## Class类

### Class类的动态加载

Class类是JVM在执行过程中动态加载的，JVM在第一次读取一种class的类型的时候，将其加载进内存。
每加载一种class，JVM就创建一个Class类型实例：
Class实例包含了该class的全部信息。

```java
public final class Class {
    private Class() {}
}
```

以String为例，当JVM加载到String时，首先读取String.class文件到内存，然后为String类创建一个Class实例并关联起来；

```java
Class cls = new Class(String);
```

每个Class实例都指向一个数据类型：
> ┌───────────────────────────┐
> │      Class Instance       │──────> String
> ├───────────────────────────┤
> │name = "java.lang.String"  │
> └───────────────────────────┘
> ┌───────────────────────────┐
> │      Class Instance       │──────> Random
> ├───────────────────────────┤
> │name = "java.util.Random"  │
> └───────────────────────────┘
> ┌───────────────────────────┐
> │      Class Instance       │──────> Runnable
> ├───────────────────────────┤
> │name = "java.lang.Runnable"│
> └───────────────────────────┘

一个Class实例包含了该class的所有完整信息：

> ┌───────────────────────────┐
> │      Class Instance       │──────> String
> ├───────────────────────────┤
> │name = "java.lang.String"  │
> ├───────────────────────────┤
> │package = "java.lang"      │
> ├───────────────────────────┤
> │super = "java.lang.Object" │
> ├───────────────────────────┤
> │interface = CharSequence...│
> ├───────────────────────────┤
> │field = value[],hash,...   │
> ├───────────────────────────┤
> │method = indexOf()...      │
> └───────────────────────────┘

JVM在执行java程序的时候，不是一次把所有的class全部加载到内存，而是第一次需要用到class的时候才加载；
通过动态加载的特性，才能在运行时根据条件加载不同的类，例如Commons Logging总是先使用Log4j，只有当Log4j不存在时，才使用JDK的logging：

```java
// Commons Logging优先使用Log4j:
LogFactory factory = null;
if (isClassPresent("org.apache.logging.log4j.Logger")) {
    factory = createLog4j();
} else {
    factory = createJdkLog();
}

boolean isClassPresent(String name) {
    try {
        Class.forName(name);
        return true;
    } catch (Exception e) {
        return false;
    }
}
```

因此只要将Log4j的jar放到classpath中，就会自动使用Log4j；

### Class实例的获取

- 通过一个class的静态变量直接获取：

    ```java
    Class cls = String.class;
    ```

- 通过该实例变量提供的getClass()方法获取：

    ```java
    String s = "Hello";
    Class cls = s.getClass()
    ```

- 通过完整类名和静态方法获取：

    ```java
    Class cls = Class.forName("java.lang.String");
    ```

### Class实例的比较

```java
Integer n = new Integer(123);

boolean b1 = n instanceof Integer; // true，因为n是Integer类型
boolean b2 = n instanceof Number; // true，因为n是Number类型的子类

boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
boolean b4 = n.getClass() == Number.class; // false，因为Integer.class!=Number.class
```

- instance不仅匹配指定类型，还匹配指定类型的子类；
- ==判断class可以精确的判断实例是不是同一个

### 通过Class实例来创建对象

```java
// 获取String的Class实例:
Class cls = String.class;
// 创建一个String实例:
String s = (String) cls.newInstance();
```

注意：只能通过public的无参构造函数来创建对象；

## 访问字段

### 获取Field

```java
class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;
}
```

Class提供了以下几种方式获取Field：

- **Field getField(name)**：根据字段名获取某个public的field（包括父类）
- **Field getDeclaredField(name)**：根据字段名获取当前类的某个field（不包括父类）
- **Field[] getFields()**：获取所有public的field（包括父类）
- **Field[] getDeclaredFields()**：获取当前类的所有field（不包括父类）

一个Field对象包含了一个字段的所有信息：

- **getName()**：返回字段名称，例如，"name"；
- **getType()**：返回字段类型，也是一个Class实例，例如，String.class；
- **getModifiers()**：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。

例如：

```java
public int Student.score
public java.lang.String Person.name
private int Student.grade
```

### 通过Field访问value

- 假设有对象如下：

    ```java
    Object p = new Person("Xiao Ming");
    ```

- 首先获取一个Field

    ```java
    Class c = p.getClass();
    Field f = c.getDeclaredField("name");
    ```

- 可以设置字段访问权限（预防private无法访问的情况）：

    ```java
    f.setAccessible(true);
    ```

- 通过Field和对象获取target 对象，并打印值；

    ```java
    Object value = f.get(p);
    System.out.println(value); // "Xiao Ming"
    ```

- 也可以设置字段的值

    ```java
    f.set(p, "Xiao Hong");
    ```

## 调用方法

### 获取Method

- **Method getMethod(name, Class...)**：获取某个public的Method（包括父类）
- **Method getDeclaredMethod(name, Class...)**：获取当前类的某个Method（不包括父类）
- **Method[] getMethods()**：获取所有public的Method（包括父类）
- **Method[] getDeclaredMethods()**：获取当前类的所有Method（不包括父类）

示例：

```java
public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Class stdClass = Student.class;
        try {
            System.out.println(stdClass.getMethod("getName"));
            System.out.println(stdClass.getMethod("getGrade", int.class));
            System.out.println(stdClass.getDeclaredMethod("getScore", String.class));
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    public String getName() {
        return "XiaoMing";
    }
}

class Student extends Person {
    public int getScore(String type) {
        return 99;
    }

    public int getGrade(int year) {
        return 1;
    }
}
```

- 输出如下：

    ```java
    public java.lang.String com.example.Person.getName()
    public int com.example.Student.getGrade(int)
    public int com.example.Student.getScore(java.lang.String)
    ```

一个Method对象包含一个方法的所有信息：

- **getName()：返回方法名称，例如**："getScore"；
- **getReturnType()：返回方法返回值类型，也是一个Class实例，例如**：String.class；
- **getParameterTypes()：返回方法的参数类型，是一个Class数组，例如**：{String.class, int.class}；
- **getModifiers()**：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。

### 调用方法

- 普通方法：

    ```java
    public static void callMethods() {
        String s = "Hello world!";
        try {
            Method m = String.class.getMethod("substring", int.class);
            m.setAccessible(true); //针对非public的情况处理
            String r = (String) m.invoke(s, 6);
            System.out.println(r);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    ```

- 静态方法：

    ```java
    public static void callStaticMethods() {
        try {
            Method m = Integer.class.getMethod("parseInt", String.class);
            // 由于静态方法不绑定实例，因此第一个参数填null
            m.setAccessible(true); // 对非public情况处理
            Integer r = (Integer) m.invoke(null, "12345");
            System.out.println(r);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    ```

此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，那么它会根据规则进行检查，有可能阻止setAccessible(true)。例如，某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，这样可以保证JVM核心库的安全。

## 调用构造方法
