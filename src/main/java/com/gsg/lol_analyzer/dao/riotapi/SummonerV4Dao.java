package com.gsg.lol_analyzer.dao.riotapi;

import com.gsg.lol_analyzer.entity.Summoner;
import reactor.core.publisher.Mono;

public interface SummonerV4Dao {

    public Mono<Summoner> getSummonerByName(String summonerName);
}
