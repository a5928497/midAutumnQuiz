package com.yukoon.midautumnquiz.services;

import com.yukoon.midautumnquiz.entities.Puzzle;
import com.yukoon.midautumnquiz.repo.PuzzleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PuzzleService {

    @Autowired
    private PuzzleRepo puzzleRepo;

    @Transactional
    public List<Puzzle> findAll() {
        List<Puzzle> list = puzzleRepo.findAll();
        return list;
    }

    public List<Puzzle> sort(List<Puzzle> puzzles) {
        Collections.sort(puzzles, new Comparator<Puzzle>() {
            @Override
            public int compare(Puzzle o1, Puzzle o2) {
                boolean flag = o1.getOrder() > o2.getOrder();
                if (flag) {
                    return 1;
                }
                return -1;
            }
        });
        return puzzles;
    }
}
