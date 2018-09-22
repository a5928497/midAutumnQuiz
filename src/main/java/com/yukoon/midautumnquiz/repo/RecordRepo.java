package com.yukoon.midautumnquiz.repo;

import com.yukoon.midautumnquiz.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepo extends JpaRepository<Record,Integer> {
}
