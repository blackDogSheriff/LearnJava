public class Od2ConStruct {
    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person("John", 15);
    }

}

class Person {
    private String name;
    private int age;

    // 默认构造函数
    public Person() {
        this("Unnamed");
    }

    // 一旦创建了构造函数，就不会自动创建默认构造函数了
    public Person(String name, int age) {
        this.name = name; // 默认初始化为null
        this.age = age; // 默认初始化为0

        // this.name = "John"; //创建对象并初始化，然后才执行构造函数
    }

    public Person(String name) {
        this(name, 18); // 调用另一个构造方法

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
