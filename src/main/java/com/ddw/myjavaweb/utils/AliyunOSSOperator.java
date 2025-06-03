package com.ddw.myjavaweb.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Random;

import com.aliyun.oss.*;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import com.aliyuncs.exceptions.ClientException;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;

@Component
public class AliyunOSSOperator {
    public void upload() throws com.aliyuncs.exceptions.ClientException {
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    String bucketName = "java-ai-ding2345";
    String region = "cn-beijing";
    // 从环境变量中获取访问凭证。运行本代码示例之前，请先配置环境变量
    EnvironmentVariableCredentialsProvider credentialsProvider =
            CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

    // 创建OSSClient实例。
    // 当OSSClient实例不再使用时，调用shutdown方法以释放资源。
    ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
    // 显式声明使用 V4 签名算法
    clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
    OSS ossClient = OSSClientBuilder.create()
            .endpoint(endpoint)
            .credentialsProvider(credentialsProvider)
            .region(region)
            .build();
    try {
        //上传文件
        //文件名
        String objectName = "exampledir/exampleobject.txt";
        //文件内容
        String content = "Hello OSS";
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
        System.out.println("2. 文件 " + objectName + " 上传成功。");
    } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
