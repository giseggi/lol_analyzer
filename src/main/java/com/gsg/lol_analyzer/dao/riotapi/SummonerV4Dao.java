package com.gsg.lol_analyzer.dao.riotapi;

import com.gsg.lol_analyzer.entity.Summoner;

public interface SummonerV4Dao {
    public Summoner getSummonerByName(String summonerName);
}
