public class Od3Reload {
    public static void main(String[] args) {

    }
}

class Hello {
    // 函数名相同，但是参数不通
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Sorry, you are too young!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}
