class Person {
    private String name;
    private int age;
    private int birth;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            this.name = name.trim();
    }

    public int getAge() {
        return calcAge(2023);
    }

    public void setAge(int age) {
        if (age > 150 || age < 0)
            throw new IllegalArgumentException("invalid age value");
        this.age = age;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    private int calcAge(int currentYear) {
        return currentYear - this.birth;
    }

    public void run() throws Exception {
        System.out.println("Person.run");
    }

}

class Group {
    private String[] names;

    public void printNames() {
        System.out.print("Names: ");
        for (String name : this.names) {
            System.out.print(name);
        }
        System.out.println();
    }

    public void setNames(String... names) {
        // this.names = names; // names直接指向了数组，而不是进行复制，java中数组是个引用
        this.names = names.clone();
        printNames();

    }

    public void setNames1(String[] names) {
        this.names = names;
        printNames();
    }
}

public class Od1Function {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.setBirth(2008);
        System.out.println(ming.getAge());

        Group group = new Group();
        group.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
        group.setNames(); // 传入的是一个空数组

        Group g = new Group();
        g.setNames1(new String[] { "Xiao Ming", "Xiao Hong", "Xiao Jun" }); // 传入1个String[]
        g.setNames1(null); // 传入空数组会导致报错
    }

}
