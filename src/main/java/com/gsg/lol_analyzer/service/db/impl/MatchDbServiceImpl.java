package com.gsg.lol_analyzer.service.db.impl;

import com.gsg.lol_analyzer.dao.repository.MatchRecordRepository;
import com.gsg.lol_analyzer.entity.MatchRecord;
import com.gsg.lol_analyzer.service.db.MatchDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MatchDbServiceImpl implements MatchDbService {

    private final MatchRecordRepository repository;

    @Override
    public void saveMatchRecord(MatchRecord matchRecord) {
        repository.save(matchRecord);
    }
}
