package com.example;

public class Main {
    public static void main(String[] args) {
        // enum实例只能定义，无法new出来
        Weekday day = Weekday.SUN;
        // 由于enum只有一个唯一实例，可以直接使用==比较
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("today is " + day + " work at home");
        } else {
            System.out.println("today is " + day + " work at office");
        }

        // 返回实例名称
        System.out.println(Weekday.SUN.name());
        // 返回下标
        System.out.println(Weekday.FRI.ordinal());

        print();
    }

    public static void print() {
        Weekday day = Weekday.SUN;
        switch (day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}