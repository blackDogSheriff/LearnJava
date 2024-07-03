package com.example;

import java.util.HashMap;
import java.util.Map;

public class PolicyUtils {
    public static Map<Integer, S3Action> apiActionMap = new HashMap<>();
    static {
        System.out.println("PolicyUtils.static starting");
        int i = 0;
        apiActionMap.put(i++, S3Action.PutBucket);
        apiActionMap.put(i++, S3Action.ListBucket);
        apiActionMap.put(i++, S3Action.ListBucket);
        apiActionMap.put(i++, S3Action.DeleteBucket);
        apiActionMap.put(i++, S3Action.GetBucketAcl);
        apiActionMap.put(i++, S3Action.PutBucketAcl);
        apiActionMap.put(i++, S3Action.GetBucketLogging);
        apiActionMap.put(i++, S3Action.PutBucketLogging);
        apiActionMap.put(i++, S3Action.GetBucketLocation);
        apiActionMap.put(i++, S3Action.PutBucketPolicy);
        apiActionMap.put(i++, S3Action.GetBucketPolicy);
        apiActionMap.put(i++, S3Action.DeleteBucketPolicy);
        apiActionMap.put(i++, S3Action.PutBucketCORS);
        apiActionMap.put(i++, S3Action.GetBucketCORS);
        apiActionMap.put(i++, S3Action.PutBucketCORS);
        apiActionMap.put(i++, S3Action.ListBucketMultipartUploads);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.PutObject);
        apiActionMap.put(i++, S3Action.AbortMultipartUpload);
        apiActionMap.put(i++, S3Action.GetObject);
        apiActionMap.put(i++, S3Action.GetObject);
        apiActionMap.put(i++, S3Action.DeleteObject);
        apiActionMap.put(i++, S3Action.GetObjectAcl);
        apiActionMap.put(i++, S3Action.PutObjectAcl);
        apiActionMap.put(i++, S3Action.GetObjectTagging);
        apiActionMap.put(i++, S3Action.PutObjectTagging);
        apiActionMap.put(i++, S3Action.DeleteObjectTagging);
        apiActionMap.put(i++, S3Action.ListMultipartUploadParts);
        apiActionMap.put(i++, S3Action.DeleteObject);
        apiActionMap.put(i++, S3Action.ListBuckets);
        apiActionMap.put(i++, S3Action.GetBucketLifeCycle);
        apiActionMap.put(i++, S3Action.PutBucketLifeCycle);
        apiActionMap.put(i++, S3Action.DeleteBucketLifeCycle);
        apiActionMap.put(i++, S3Action.PostObjectRestore);
        apiActionMap.put(i++, S3Action.PutBucketReplication);
        apiActionMap.put(i++, S3Action.GetBucketReplication);
        apiActionMap.put(i++, S3Action.DeleteBucketReplication);
        apiActionMap.put(i++, S3Action.GetObject);
        apiActionMap.put(i++, S3Action.GetObject);
        apiActionMap.put(i++, S3Action.PutBucketMirror);
        apiActionMap.put(i++, S3Action.GetBucketMirror);
        apiActionMap.put(i++, S3Action.DeleteBucketMirror);
        apiActionMap.put(i++, S3Action.PutObjectLinking);
        apiActionMap.put(i++, S3Action.PutBucketInventory);
        apiActionMap.put(i++, S3Action.GetBucketInventory);
        apiActionMap.put(i++, S3Action.DeleteBucketInventory);
        apiActionMap.put(i++, S3Action.ListBucketInventory);
        apiActionMap.put(i++, S3Action.PutBucketEncryption);
        apiActionMap.put(i++, S3Action.GetBucketEncryption);
        apiActionMap.put(i++, S3Action.DeleteBucketEncryption);

        for (S3Action action : PolicyUtils.apiActionMap.values()) {
            System.out.println("1. name: " + action.name() + ", action: " + action.action);
        }
    }

}