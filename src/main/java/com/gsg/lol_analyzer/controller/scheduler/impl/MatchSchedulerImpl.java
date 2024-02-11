package com.gsg.lol_analyzer.controller.scheduler.impl;

import com.gsg.lol_analyzer.controller.scheduler.MatchScheduler;
import com.gsg.lol_analyzer.service.riotapi.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MatchSchedulerImpl implements MatchScheduler {

    private final SummonerService summonerService;

    @Scheduled(cron = "0 0 0 * * ?") // Every 12:00 AM
    @Override
    public void saveMatchRecordsDaily() {

    }
}
