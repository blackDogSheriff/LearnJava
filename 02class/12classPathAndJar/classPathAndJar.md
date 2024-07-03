# ClassPathAndJar

[TOC]
---

## ClassPath

- classpath是JVM的一个环境变量，用来检索`class`，

### class检索逻

现在我们假设classpath是.;C:\work\project1\bin;C:\shared，当JVM在加载abc.xyz.Hello这个类时，会依次查找：

- <当前目录>\abc\xyz\Hello.class
- C:\work\project1\bin\abc\xyz\Hello.class
- C:\shared\abc\xyz\Hello.class

### 设置classpath

推荐在JVM启动项中设置classpath，而不是环境变量`classpath`中；

- `java -classpath .;C:\work\project1\bin;C:\shared abc.xyz.Hello`
- `java -cp .;C:\work\project1\bin;C:\shared abc.xyz.Hello`

在IDE中，IDE会自动将**当前目录bin目录**和**引入的jar包**设置到`classpath`中；

## jar包

- jar包就是一个普通的zip包；
- `/META-INF/MANIFEST.MF`：jar包中的一个纯文本文件，可以指定`Main-class`和其他信息；JVM自动读取该文件，如果存在`Main-class`，就不许在命令行指定启动的类名，直接执行`java -jar xxx.jar`即可；
