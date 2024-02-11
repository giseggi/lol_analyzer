package com.gsg.lol_analyzer.controller.executor;

import java.util.Map;

public interface MatchExecutor {

    void saveMatchRecord(Map<String, Object> requestBody) throws InterruptedException;
}
