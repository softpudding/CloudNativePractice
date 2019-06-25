package wordladder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix //Hystrix support
public class Application {

    public static void main(String[] args) {
	  //now we have CI!
        SpringApplication.run(Application.class, args);
    }
}