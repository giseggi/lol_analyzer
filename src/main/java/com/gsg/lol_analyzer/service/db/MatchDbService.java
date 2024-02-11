package com.gsg.lol_analyzer.service.db;

import com.gsg.lol_analyzer.entity.MatchRecord;
import reactor.core.publisher.Mono;

public interface MatchDbService {

    void saveMatchRecord(MatchRecord matchRecord);
}
