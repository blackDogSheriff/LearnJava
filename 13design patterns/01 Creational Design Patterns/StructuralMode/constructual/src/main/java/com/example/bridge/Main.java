package com.example.bridge;

/*
 * 有限数量的engine
 * 有限数量的car
 * 相互组合，可以节省car类型
 */
public class Main {
    public static void main(String[] args) {
        RefinedCar car = new BossCar(new HybridEngine());
        car.drive();
    }

}
