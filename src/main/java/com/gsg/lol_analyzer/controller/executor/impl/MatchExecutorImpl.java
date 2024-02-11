package com.gsg.lol_analyzer.controller.executor.impl;

import com.gsg.lol_analyzer.controller.executor.MatchExecutor;
import com.gsg.lol_analyzer.service.db.MatchDbService;
import com.gsg.lol_analyzer.service.riotapi.MatchService;
import com.gsg.lol_analyzer.service.riotapi.SummonerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
@Slf4j
public class MatchExecutorImpl implements MatchExecutor {

    private final SummonerService summonerService;

    private final MatchService matchService;

    private final MatchDbService matchDbService;

    @Override
    @PostMapping(value = "/saveMatchRecord")
    public void saveMatchRecord(@RequestBody Map<String, Object> requestBody) {
        String summonerName = (String)requestBody.get("summonerName");
        summonerService.getPuuid(summonerName)
                .flatMapMany(puuid -> {
                    if (Objects.nonNull(puuid)) {
                        log.info("puuid: {}", puuid);
                        return matchService.makeMatchRecord(puuid, (String)requestBody.get("type"), (int)requestBody.get("count"));
                    } else {
                        return Mono.error(new RuntimeException("PUUID not found"));
                    }
                })
                .flatMap(Mono::just)
                .subscribe(result -> {
                    matchDbService.saveMatchRecord(result);
                    log.info("Match record saved successfully");
                }, error -> {
                    log.error("Failed to save match record", error);
                });
    }
}
