package com.gsg.lol_analyzer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "baseurl")
@Data
public class ApiProperties {
    String apiKey;
    Map<String, String> baseUrl;
}
