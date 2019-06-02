package wordladder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
	  //now we have CI!
        SpringApplication.run(Application.class, args);
    }
}