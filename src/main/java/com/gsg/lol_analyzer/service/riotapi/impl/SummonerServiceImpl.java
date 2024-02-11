package com.gsg.lol_analyzer.service.riotapi.impl;

import com.gsg.lol_analyzer.dao.riotapi.SummonerV4Dao;
import com.gsg.lol_analyzer.entity.Summoner;
import com.gsg.lol_analyzer.service.riotapi.SummonerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
@Slf4j
public class SummonerServiceImpl implements SummonerService {

    private final SummonerV4Dao summonerV4Dao;

    @Override
    public Mono<String> getPuuid(String summonerName) {
        return summonerV4Dao.getSummonerByName(summonerName).map(Summoner::getPuuid);
    }

    private String getPuuid(Summoner summoner) {
        return summoner.getPuuid();
    }
}
