package ZCWDelta.ZipTube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class ZipTubeApplication {

	public static void main(String[] args) {
		S3Client s3 = new S3Client();
		String bucketName = "ZipTubeBucket";
		s3.createBucket(bucketName);
		s3.generatePresignedUrl(bucketName, "lmao");
		SpringApplication.run(ZipTubeApplication.class, args).getResource("s3://" + bucketName);
	}

}
