package com.example.builder;

public class Main {
    public static void main(String[] args) {
        boolean secure = false;
        StringBuilder builder = new StringBuilder();
        builder.append(secure ? "https://" : "http://")
                .append("www.liaoxuefeng.com")
                .append("/")
                .append("?t=0");
        String url = builder.toString();

        System.out.println(url);
    }

}
