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

    //删除
    @Transactional
    public void delete(Integer id){
        puzzleRepo.delete(id);
    }

    //保存puzzle
    @Transactional
    public void save(Puzzle puzzle) {
        puzzleRepo.saveAndFlush(puzzle);
    }

    //查找puzzle
    public Puzzle findById(Integer id) {
        return puzzleRepo.findOne(id);
    }

    //查询所有问题
    @Transactional
    public List<Puzzle> findAll() {
        List<Puzzle> list = puzzleRepo.findAll();
        return list;
    }

    //查询第一个问题
    public Puzzle findFirst() {
        List<Puzzle> list = findAll();
        Puzzle puzzle = null;
        if (list.size() >0 && null != list) {
            puzzle = list.get(0);
            for (Puzzle tmp : list) {
                if (tmp.getOrder() < puzzle.getOrder()){
                    puzzle = tmp;
                }
            }
        }
        return puzzle;
    }

    public List<Puzzle> sortAll() {
        List<Puzzle> puzzles = findAll();
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

    public Puzzle getNextPuzzle(Integer order) {
        List<Puzzle> puzzles = sortAll();
        Puzzle puzzle = null;
        for (int i =0;i<puzzles.size();i++) {
            if (puzzles.get(i).getOrder() == order) {
                return puzzles.get(i+1);
            }
        }
        return puzzle;
    }
}
