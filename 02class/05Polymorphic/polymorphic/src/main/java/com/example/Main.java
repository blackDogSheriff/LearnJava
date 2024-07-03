package com.example;

import com.example.income.Income;
import com.example.income.SalaryIncome;
import com.example.income.StateCouncilSpecialAllowance;
import com.example.person.Person;
import com.example.person.Student;

public class Main {
    public static void main(String[] args) {
        Person p = new Student();
        // java方法调用基于基于运行时的实际类型的动态调用，也就是多态（Polymorphic）
        p.run(); // 打印Student覆写后的方法

        // 多态展示
        Income[] incomes = new Income[] {
                new Income(3000),
                new SalaryIncome(7000),
                new StateCouncilSpecialAllowance(10000)
        };
        System.out.println(totalTax(incomes));
    }

    public static void runTwice(Person p) {
        p.run(); // 只有在运行时才能确定具体的传入对象
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}