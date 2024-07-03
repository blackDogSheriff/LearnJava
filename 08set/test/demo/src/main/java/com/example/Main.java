package com.example;

public class Main {

    public static void main(String[] args) {

        System.out.println("main starting");
        for (S3Action action : PolicyUtils.apiActionMap.values()) {
            System.out.println("2. name: " + action.name() + ", action: " + action.action);
            // if (action.equals(S3Action.PutBucketLifeCycle)) {
            // }
        }
    }
}