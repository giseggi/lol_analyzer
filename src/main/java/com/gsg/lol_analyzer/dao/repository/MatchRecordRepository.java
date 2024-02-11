package com.gsg.lol_analyzer.dao.repository;

import com.gsg.lol_analyzer.entity.MatchRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRecordRepository extends JpaRepository<MatchRecord, Long> {
}
