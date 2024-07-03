package com.example;

public enum Weekday {
    SUN(0, "星期一"),
    MON(1, "星期二"), 
    TUE(2, "星期三"), 
    WED(3, "星期四"), 
    THU(4, "星期五"), 
    FRI(5, "星期六"), 
    SAT(6, "星期日");

    public final int dayValue;
    public final String dayChinese;

    private Weekday(int dayValue, String dayChinese) {
        this.dayValue = dayValue;
        this.dayChinese = dayChinese;
    }

    @Override
    public String toString() {
        return this.dayChinese;
    }
}
