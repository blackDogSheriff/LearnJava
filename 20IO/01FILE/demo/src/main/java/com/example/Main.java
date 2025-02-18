package com.example;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        // 此处使用绝对路径，也可以使用相对路径
        // 即使文件不存在，也不会报错，只有使用该对象的时候才会进行磁盘操作
        File f = new File("C:\\Users\\93786\\Desktop\\111\\22.txt");
        System.out.println(f);

        File f1 = new File("C:\\Windows");
        File f2 = new File("C:\\Windows\\notepad.exe");
        File f3 = new File("C:\\Windows\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());

        /*
         * 创建/删除文件
         */
        File file = new File("C:\\Users\\93786\\Desktop\\111\\23.txt");
        if (file.createNewFile()) {
            if (file.delete()) {
            }
        }

        /*
         * 遍历文件和目录
         */

        File dir = new File("C:\\Users\\93786\\Desktop\\111");
        File[] files = dir.listFiles();
        printFiles(files);

        /*
         * PATH对象
         */

        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println(p1);

        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2);

        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);

        File ff = p3.toFile(); // 转换为File对象
        System.out.println(f);

        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }
    }

    static void printFiles(File[] files) {
        System.out.println("==================");
        if (files != null) {

            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==================");
    }
}