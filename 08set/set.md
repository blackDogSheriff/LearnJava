# SET

---
Java标准库自带的`java.util`包提供了集合类：Collection，它是除Map外所有其他集合类的根接口。Java的java.util包主要提供了以下三种类型的集合：

- **List**：一种有序列表的集合，例如，按索引排列的Student的List；
- **Set**：一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
- **Map**：一种通过键值（key-value）查找的映射表集合，例如，根据Student的name查找对应Student的Map。

Java集合的设计有几个**特点**：

- 实现了接口和实现类相分离，例如，有序表的接口是List，具体的实现类有ArrayList，LinkedList等；
- 支持泛型，我们可以限制在一个集合中只能放入同一种数据类型的元素，例如：

    ```java
    List<String> list = new ArrayList<>(); // 只能放入String类型
    ```

最后，Java访问集合总是通过统一的方式——迭代器（Iterator）来实现，它最明显的好处在于无需知道集合内部元素是按什么方式存储的。

## 使用list

### List主要类型

#### ArrayList

- 内部使用有序数组来存储所有的元素；
- 实际数组大小比元素个数多一个；
- 如果数组已满，继续添加元素的时候，ArrayList会创建一个更大的数组，然后把旧的数组复制到新的数组，紧接着使用新数组取代旧数组；

#### LinkedList

LinkedList也就是**单向链表**，每个元素指向下一个元素；

## List基本操作

- 在末尾添加一个元素：boolean add(E e)
- 在指定索引添加一个元素：boolean add(int index, E e)
- 删除指定索引的元素：E remove(int index)
- 删除某个元素：boolean remove(Object e)
- 获取指定索引的元素：E get(int index)
- 获取链表大小（包含元素的个数）：int size()
