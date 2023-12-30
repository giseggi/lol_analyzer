package com.gsg.lol_analyzer.controller.scheduler.impl;

import com.gsg.lol_analyzer.controller.scheduler.MatchScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MatchSchedulerImpl implements MatchScheduler {

    @Scheduled(cron = "0 0 0 * * ?") // Every 12:00 AM
    @Override
    public void saveMatchRecordsDaily() {

    }
}
