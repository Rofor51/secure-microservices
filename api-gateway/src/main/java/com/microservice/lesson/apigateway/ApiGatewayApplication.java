package com.microservice.lesson.apigateway;

import com.microservice.lesson.apigateway.securityconfig.AuthorizationHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public AuthorizationHeaderFilter authHeaderFilter(OAuth2AuthorizedClientService clientService) {
		return new AuthorizationHeaderFilter(clientService);
	}

}
