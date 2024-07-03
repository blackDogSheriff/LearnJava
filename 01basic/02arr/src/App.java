import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i = 0; i < ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }

        for (int n : ns) {
            System.out.println(n);
        }

        System.out.println(Arrays.toString(ns));

        String[] names = { "ABC", "XYZ", "zoo" };
        String s = names[1];
        names[1] = "cat";

        System.out.println(s);
    }

}
