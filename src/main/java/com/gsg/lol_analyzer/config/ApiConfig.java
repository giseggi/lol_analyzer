package com.gsg.lol_analyzer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class ApiConfig {

    private final ApiProperties apiProperties;

    @Bean(name = "summoner")
    public WebClient summoner() {
        return WebClient.builder().baseUrl(apiProperties.getBaseUrl().get("summoner"))
                .defaultHeader("X-Riot-Token", apiProperties.getApiKey()).build();
    }

    @Bean(name = "match")
    public WebClient match() {
        return WebClient.builder().baseUrl(apiProperties.getBaseUrl().get("match"))
                .defaultHeader("X-Riot-Token", apiProperties.getApiKey()).build();
    }
}
