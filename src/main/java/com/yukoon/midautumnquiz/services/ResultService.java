package com.yukoon.midautumnquiz.services;

import com.yukoon.midautumnquiz.entities.Result;
import com.yukoon.midautumnquiz.repo.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ResultService {
    @Autowired
    private ResultRepo resultRepo;

    public Result getRandomResultByBelongTo(Integer belongTo) {
        Random random = new Random();
        List<Result> list = resultRepo.findByBelongTo(belongTo);
        return list.get(random.nextInt(list.size()+1));
    }

    public List<Result> findAll() {
        return resultRepo.findAll();
    }

    public Result findById(Integer id) {
        return resultRepo.findOne(id);
    }

    public void save(Result result) {
        resultRepo.saveAndFlush(result);
    }

    public void delete(Integer id) {
        resultRepo.delete(id);
    }
}
