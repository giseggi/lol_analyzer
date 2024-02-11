package com.gsg.lol_analyzer.service.riotapi;

import reactor.core.publisher.Mono;

public interface SummonerService {

    Mono<String> getPuuid(String summonerName);
}
