package com.gsg.lol.analyzer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Summoner {
    @Id
    private String id;

    private String accountId;

    private String puuid;

    private String name;

    private Long summonerLevel;

}
