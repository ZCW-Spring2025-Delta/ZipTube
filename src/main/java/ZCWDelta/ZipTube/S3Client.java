package ZCWDelta.ZipTube;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.io.File;
import java.net.URL;
import java.util.Date;

@Component
@Validated
public class S3Client {

    private final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();

    // Create an S3 bucket
    public void createBucket(String bucketName) {
        s3.createBucket(bucketName);
    }

    // Upload an object to S3
    public void uploadObject(String bucketName, String key, File file) {
        s3.putObject(bucketName, key, file);
    }

    // Download an object from S3
    public void downloadObject(String bucketName, String key, File file) {
        s3.getObject(new GetObjectRequest(bucketName, key), file);
    }

    // List objects in a bucket
    public ObjectListing listObjects(String bucketName) {
        return s3.listObjects(bucketName);
    }

    // Generate pre-signed URL to share an S3 object
    public URL generatePresignedUrl(String bucketName, String key) {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60; // Add 1 hour.
        expiration.setTime(expTimeMillis);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, key)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expiration);

        return s3.generatePresignedUrl(generatePresignedUrlRequest);
    }
}