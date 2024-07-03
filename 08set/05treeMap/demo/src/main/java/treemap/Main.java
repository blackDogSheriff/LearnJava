package treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
 * HashMap是一种以空间换时间的映射表，它的实现原理决定了内部的Key是无序的，即遍历HashMap的Key时，其顺序是不可预测的（但每个Key都会遍历一次且仅遍历一次）
 * 还有一种Map，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        /*
         * 使用TreeMap的时候，放入的key必须实现comparable接口
         * 如果没有实现comparable接口，那么必须在创建TreeMap时同时指定一个自定义排序算法
         */

        Map<Person, Integer> map1 = new TreeMap<>(new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        Map<Student, Integer> map2 = new TreeMap<>(new Comparator<Student>() {
            public int compare(Student p1, Student p2) {
                if (p1.score == p2.score) {
                    return 0;
                }
                return p1.score > p2.score ? -1 : 1;
            }
        });

        map2.put(new Student("Tom", 77, 33), 1);
        map2.put(new Student("Bob", 66, 44), 2);
        map2.put(new Student("Lily", 99, 55), 3);

        for (Student key : map2.keySet()) {
            System.out.println(key);
        }

    }
}