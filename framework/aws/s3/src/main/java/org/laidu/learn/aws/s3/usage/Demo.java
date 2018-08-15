package org.laidu.learn.aws.s3.usage;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * demo
 *
 * @author tiancai.zang
 * on 2018-08-15 18:08.
 */
@Slf4j
public class Demo {

//    private static final String BUCKET_NAME = "demo-dev";
    private static final String BUCKET_NAME = "zhibaosuixing-test";
    private static final String PROFILE_NAME = "insurance";


    /**
     * 使用同步接口访问 s3, 需要在运行时环境变量中指定配置
     */
    public static void syncClientWithProfineCred(){

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()

                .withCredentials(new ProfileCredentialsProvider(PROFILE_NAME))
                .withRegion(Regions.CN_NORTH_1)
                .build();

        // list all objects
        s3Client.listObjects(BUCKET_NAME).getObjectSummaries().forEach(s -> {
            System.out.println(String.format("fileName: %s, fileSize: %.2fkb",s.getKey(),s.getSize()/1024.0));
        });


    }


    public static void main(String[] args) {

        syncClientWithProfineCred();

    }
}