package com.example;
import com.example.ab.*;

public class Main {
    public static void main(String[] args) {
        /*
         * 面向抽象编程
         * - 上层代码只定义规范
         * - 不需要子类就可以编译
         * - 具体的业务逻辑由不通的子类实现，调用者并不关心；
         */
        Person s = new Student();
        Person t = new Teacher();

        // 不关心子类具体类型
        s.run();
        t.run();
    }

}
