import java.util.Arrays;

public class Sort {
    public enum REGION {
        BEIJING,
        HANGZHOU,
        JIYANG,
        AMERICA,
        HONGKONG,
        SHANGHAI,
        SINGAPORE,
        GUANGZHOU,
        RUSSIA,
        TAIWAN,
        QINGDAO,
        JR_BEIJING,
        JR_SHANGHAI,
        INDIA, // 印度
        GOV_BEIJING, // 北京政务
        QINGYANGPRE,
        SINGAPORE2,
        NINGXIA,
        TIANJIN_XM01
    }

    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        Arrays.sort(ns);

        for (REGION region : REGION.values()) {
            System.out.println(region);
        }
    }

}
