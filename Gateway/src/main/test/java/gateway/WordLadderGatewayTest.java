package gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {"wordladderService=http://localhost:${wiremock.server.port}"})
@AutoConfigureWireMock(port = 0)
public class WordLadderGatewayTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void contextLoads() throws Exception {
        //Stubs
        stubFor(get(urlEqualTo("/"))
                .willReturn(aResponse()
                        .withBody("{\"headers\":{\"Router\":\"WordLadder-Gateway\"}}")
                        .withHeader("Content-Type", "application/json")));
        webClient
                .get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.headers.Router").isEqualTo("WordLadder-Gateway");
    }
}
