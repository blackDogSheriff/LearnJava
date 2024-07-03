package unummap;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

// hashMap是一种通过key计算hashcode()，通过空间交换时间的方式，直接定位到value所在的内部数组的索引，因此查找的效率非常高

//如果key的对象类型是Enum，那个还可以使用java提供的一种EnumMap，一种非常紧凑的数组存储value，并且根据
// enum类型的key直接定位到内部数组的索引，并不需要计算hashcode()，不但效率搞，而且没有额外空间浪费
// 理解：enum本身就是int，且唯一，不需要再重新计算hashcode
public class Main {
    public static void main(String[] args) {
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
    }
}