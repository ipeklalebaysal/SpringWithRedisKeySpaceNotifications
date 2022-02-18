package com.redisDemoApp.wiremockClient;

import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WireMockClient {

//	@Value("${wiremock.baseUrl}")
//	private String url;

	private String url = "http://wiremock:8080";

	public void getFromWiremock() {
		WebClient client = WebClient.builder()
		                            .baseUrl(url)
		                            .defaultCookie("cookieKey", "cookieValue")
		                            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		                            .defaultUriVariables(Collections.singletonMap("url", url))
		                            .build();

		WebClient.RequestHeadersUriSpec uriSpec = client.get();

		WebClient.RequestHeadersSpec bodySpec = uriSpec.uri("/test");

		Mono<String> response = bodySpec.retrieve()
		                                   .bodyToMono(String.class);

		response.subscribe(System.out::println);
	}

}
