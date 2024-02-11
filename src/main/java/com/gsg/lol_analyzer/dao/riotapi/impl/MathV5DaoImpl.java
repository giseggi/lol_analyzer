package com.gsg.lol_analyzer.dao.riotapi.impl;

import com.gsg.lol_analyzer.config.ApiProperties;
import com.gsg.lol_analyzer.dao.riotapi.MathV5Dao;
import com.gsg.lol_analyzer.entity.MatchRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MathV5DaoImpl implements MathV5Dao {

    @Qualifier("match")
    private final WebClient webClient;

    @Override
    public Flux<String> getMatchId(String puuid, String type, int count) {
        return webClient.get().uri(uriBuilder ->
                uriBuilder.path("/by-puuid").path("/" + puuid).path("/ids")
                        .queryParam("type", type)
                        .queryParam("start", 0)
                        .queryParam("count", count).build())
                .retrieve()
                .bodyToMono(String.class)  // JSON 배열을 하나의 문자열로 읽음
                .flatMapMany(jsonArray -> Flux.fromArray(jsonArray.replaceAll("[\\[\\]\"]", "").split(",")))  // 대괄호와 쌍따옴표를 제거하고 쉼표로 나누어 각 문자열을 Flux로 변환
                .map(String::trim);  // 공백 제거
    }
}
