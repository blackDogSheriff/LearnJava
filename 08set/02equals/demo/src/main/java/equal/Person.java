package main.java.equal;

public class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /*
     * 如何正确编写equals()方法？equals()方法要求我们必须满足以下条件：
     * 
     * - 自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
     * - 对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
     * - 传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.
     * equals(z)也必须为true；
     * - 一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
     * 对null的比较：即x.equals(null)永远返回false。
     */

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person p) {
            boolean nameEquals = false;
            if (this.name == null && p.name == null) {
                nameEquals = true;
            }

            if (this.name != null) {
                nameEquals = this.name.equals(p.name);
            }

            return nameEquals && this.age == p.age;
        }

        return false;
    }

    /*
     * 因此，我们总结一下equals()方法的正确编写方法：
     * 
     * 先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
     * 用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
     * 对引用类型用Objects.equals()比较，对基本类型直接用==比较。
     */

}
