package gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteLocator wlRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
        String wordladderService = uriConfiguration.getWordladderService();

        return builder.routes()
                .route(p -> p
                        .path("/get_wordladder")
                        .filters(f -> f.addRequestHeader("Router","WordLadder-Gateway"))
                        .uri(wordladderService+"/get_wordladder"))
                .route(p -> p
                        .path("/")
                        .filters(f -> f.addRequestHeader("Router","WordLadder-Gateway"))
                        .uri(wordladderService+"/home"))
                .route(p -> p
                        .path("/home")
                        .filters(f -> f.addRequestHeader("Router","WordLadder-Gateway"))
                        .uri(wordladderService+"/home"))
                .route(p -> p
                        .path("/wordladder")
                        .filters(f -> f.addRequestHeader("Router","WordLadder-Gateway"))
                        .uri(wordladderService+"/wordladder"))
                .route(p -> p
                        .path("/login")
                        .filters(f -> f.addRequestHeader("Router","WordLadder-Gateway"))
                        .uri(wordladderService+"/login"))
                .route(p -> p
                        .host("106.12.89.107:*")
                        .filters(f -> f.hystrix(config -> config.setName("cmd").setFallbackUri("forward:/error")))
                        .uri("http://106.12.89.107:8080"))
                .build();
    }

    @RequestMapping("/error")
    public Mono<String> fallback() {
        return Mono.just("ERROR!");
    }
}

@ConfigurationProperties
class UriConfiguration {

    private String wordladderService = "http://localhost:8083";

    public String getWordladderService() {
        return wordladderService;
    }

    public void setWordladderService(String wordladderService) {
        this.wordladderService = wordladderService;
    }
}
