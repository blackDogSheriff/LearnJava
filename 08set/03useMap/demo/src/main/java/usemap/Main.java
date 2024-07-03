package usemap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("xiaoming", 23);
        Student s1 = new Student("xiaohong", 13);
        Map<String, Student> m = new HashMap<String, Student>();
        m.put("xiaoming", s);
        m.put("xiaohong", s1);

        // 通过key获取
        Student target = m.get("xiaoming");
        if (target != null) {
            System.out.println(target == s);
            System.out.println(target.getAge());
            System.out.println(target.getName());
        }

        // 判断key是否存在
        System.out.println(m.containsKey("xiaohong"));

        // 遍历
        for (String key : m.keySet()) {
            Student t = m.get(key);
        }

        for (Map.Entry<String, Student> e : m.entrySet()) {
            String key = e.getKey();
            Student t = e.getValue();
        }

        /*
         * 通过key计算出一个整数值，找到大数组中的value对应的下标；
         * key可以是不同的对象，但是返回的int要相同，因此key的对象类型要覆写equals接口
         */

        /*
         * 因此，正确使用Map必须保证：
         * 
         * 1. 作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
         * 
         * 2. 作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
         * 
         * - 如果两个对象相等，则两个对象的hashCode()必须相等；
         * - 如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
         * 即对应两个实例a和b：
         * 
         * - 如果a和b相等，那么a.equals(b)一定为true，则a.hashCode()必须等于b.hashCode()；
         * - 如果a和b不相等，那么a.equals(b)一定为false，则a.hashCode()和b.hashCode()尽量不要相等。
         */

    }
}