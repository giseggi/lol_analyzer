package com.gsg.lol_analyzer.service.riotapi.impl;

import com.gsg.lol_analyzer.dao.riotapi.SummonerV4Dao;
import com.gsg.lol_analyzer.service.riotapi.SummonerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SummonerServiceImpl implements SummonerService {

    private final SummonerV4Dao summonerV4Dao;

    @Override
    public String getPuuid(String summonerName) {
        return summonerV4Dao.getSummonerByName(summonerName).getPuuid();
    }
}
