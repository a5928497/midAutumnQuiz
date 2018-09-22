package com.yukoon.midautumnquiz.services;

import com.yukoon.midautumnquiz.entities.Record;
import com.yukoon.midautumnquiz.entities.Result;
import com.yukoon.midautumnquiz.repo.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {
	@Autowired
	private RecordRepo recordRepo;

	@Transactional
	public Record save(Result result) {
		Record record = new Record().setResult(result);
		return recordRepo.saveAndFlush(record);
	}

	public Record findById(Integer id) {
		return  recordRepo.findOne(id);
	}
}
