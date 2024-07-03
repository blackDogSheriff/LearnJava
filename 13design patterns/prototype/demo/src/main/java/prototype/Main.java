package prototype;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] original = { "Apple", "Pear", "Banana" };
        String[] copy = Arrays.copyOf(original, original.length);

        Student student = new Student("001", "xiaoming", 100);
    }
}