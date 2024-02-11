package com.gsg.lol_analyzer.dao.riotapi;

import com.gsg.lol_analyzer.entity.MatchRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MathV5Dao {

    Flux<String> getMatchId(String puuid, String type, int count);
}
