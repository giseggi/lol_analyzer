package com.gsg.lol_analyzer.service.riotapi;

import com.gsg.lol_analyzer.entity.MatchRecord;
import reactor.core.publisher.Flux;

import java.util.List;

public interface MatchService {

   Flux<MatchRecord> makeMatchRecord(String puuid, String type, int count);
}
