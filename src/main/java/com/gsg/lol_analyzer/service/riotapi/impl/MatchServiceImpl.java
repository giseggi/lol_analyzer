package com.gsg.lol_analyzer.service.riotapi.impl;

import com.gsg.lol_analyzer.dao.riotapi.MathV5Dao;
import com.gsg.lol_analyzer.entity.MatchRecord;
import com.gsg.lol_analyzer.service.riotapi.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MathV5Dao mathV5Dao;

    @Override
    public Flux<MatchRecord> makeMatchRecord(String puuid, String type, int count) {
        return mathV5Dao.getMatchId(puuid, type, count)
                .flatMap(matchId -> {
                    return Flux.just(MatchRecord.builder().matchId(matchId).processedCode("0").build());
                })
                .onErrorResume(error -> {
                    return Flux.error(new RuntimeException("An error occurred while processing async", error));
                });
    }
}
