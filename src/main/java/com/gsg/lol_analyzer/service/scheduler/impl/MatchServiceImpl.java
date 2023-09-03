package com.gsg.lol_analyzer.service.scheduler.impl;

import com.gsg.lol_analyzer.service.scheduler.MatchService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MatchServiceImpl implements MatchService {

    @Scheduled(cron = "0 0 0 * * ?") // Every 12:00 AM
    @Override
    public void saveMatchRecordsDaily() {

    }
}
