package com.example;

public enum S3Action {

    AllS3Actions("ks3:*"),
    AllBucketActions("ks3:*Bucket"),
    AllBucketSubActions("ks3:*Bucket*"),
    ListBucket("ks3:ListBucket"), // Get Bucket, Head Bucket
    PutBucket("ks3:PutBucket"),
    DeleteBucket("ks3:DeleteBucket"),
    GetBucketAcl("ks3:GetBucketAcl"),
    PutBucketAcl("ks3:PutBucketAcl"),
    GetBucketCORS("ks3:GetBucketCORS"),
    PutBucketCORS("ks3:PutBucketCORS"),
    GetBucketLocation("ks3:GetBucketLocation"),
    GetBucketPolicy("ks3:GetBucketPolicy"),
    DeleteBucketPolicy("ks3:DeleteBucketPolicy"),
    PutBucketPolicy("ks3:PutBucketPolicy"),
    PutBucketLogging("ks3:PutBucketLogging"),
    GetBucketLogging("ks3:GetBucketLogging"),
    ListBucketMultipartUploads("ks3:ListBucketMultipartUploads"),

    AllObjectActions("ks3:*Object"),
    AllObjectSubActions("ks3:*Object*"),
    GetObject("ks3:GetObject"),
    PutObject("ks3:PutObject"),
    PutObjectLinking("ks3:PutObjectLinking"),
    DeleteObject("ks3:DeleteObject"),
    PutObjectAcl("ks3:PutObjectAcl"),
    GetObjectAcl("ks3:GetObjectAcl"),
    PutObjectTagging("ks3:PutObjectTagging"),
    GetObjectTagging("ks3:GetObjectTagging"),
    DeleteObjectTagging("ks3:DeleteObjectTagging"),
    AbortMultipartUpload("ks3:AbortMultipartUpload"),
    ListMultipartUploadParts("ks3:ListMultipartUploadParts"),
    GetBucketLifeCycle("ks3:GetBucketLifeCycle"),
    PutBucketLifeCycle("ks3:PutBucketLifeCycle"),
    DeleteBucketLifeCycle("ks3:DeleteBucketLifeCycle"),
    PostObjectRestore("ks3:PostObjectRestore"),
    PutBucketReplication("ks3:PutBucketReplication"),
    GetBucketReplication("ks3:GetBucketReplication"),
    DeleteBucketReplication("ks3:DeleteBucketReplication"),
    ListBuckets("ks3:ListBuckets"),
    GetBucketMirror("ks3:GetBucketMirror"),
    DeleteBucketMirror("ks3:DeleteBucketMirror"),
    PutBucketMirror("ks3:PutBucketMirror"),
    PutBucketInventory("ks3:PutBucketInventory"),
    GetBucketInventory("ks3:GetBucketInventory"),
    DeleteBucketInventory("ks3:DeleteBucketInventory"),
    ListBucketInventory("ks3:ListBucketInventory"),
    // 桶加密
    PutBucketEncryption("ks3:PutBucketEncryption"),
    GetBucketEncryption("ks3:GetBucketEncryption"),
    DeleteBucketEncryption("ks3:DeleteBucketEncryption"),
    GetBucketQuota("ks3:GetBucketQuota"),
    SetBucketQuota("ks3:PutBucketQuota"),;

    public final String action;

    private S3Action(String action) {
        this.action = action;
    }

    public String toString() {
        return this.action;
    }

    public static S3Action to(String act) {
        for (S3Action action : S3Action.values()) {
            if (action.action.equals(act))
                return action;
        }
        return null;
    }
}
