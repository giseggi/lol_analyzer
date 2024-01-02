package com.gsg.lol_analyzer.dao.riotapi.impl;

import com.gsg.lol_analyzer.dao.riotapi.SummonerV4Dao;
import com.gsg.lol_analyzer.entity.Summoner;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class SummonerV4DaoImpl implements SummonerV4Dao {

    @Qualifier("summoner")
    private final WebClient webClient;

    @Override
    public Summoner getSummonerByName(String summonerName) {
        return webClient.get().uri(uriBuilder ->
            uriBuilder.path(summonerName).build()).retrieve().bodyToMono(Summoner.class).block();
    }
}
