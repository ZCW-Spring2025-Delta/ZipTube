package ZCWDelta.ZipTube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.net.URL;

@SpringBootApplication
public class ZipTubeApplication {

	public static void main(String[] args) {
		S3Client s3 = new S3Client();
		String bucketName = "ziptubebucket";
		s3.createBucket(bucketName);
		URL unsignedURL = s3.generatePresignedUrl(bucketName, "/signin.html");
		SpringApplication.run(ZipTubeApplication.class, args).getResource("s3://" + bucketName);
	}

}
