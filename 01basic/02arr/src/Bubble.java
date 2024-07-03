import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - 1 - i; j++) {
                if (ns[j] > ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }
    }

}
