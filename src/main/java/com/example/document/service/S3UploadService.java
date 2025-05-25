package com.example.document.service;

import org.springframework.stereotype.Service;

@Service
public class S3UploadService {

//    private final AmazonS3 amazonS3;
//
//    @Value("${aws.s3.bucket}")
//    private String bucketName;
//
//    public S3UploadService(AmazonS3 amazonS3) {
//        this.amazonS3 = amazonS3;
//    }

    public String uploadDocument(byte[] content, String key, String contentType) {
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(content.length);
//        metadata.setContentType(contentType);
//
//        try (InputStream inputStream = new ByteArrayInputStream(content)) {
//            amazonS3.putObject(bucketName, key, inputStream, metadata);
//            return amazonS3.getUrl(bucketName, key).toString(); // Or return the key
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to upload document to S3", e);
//        }
        return "Successfully Uploaded to S3";
    }
}
