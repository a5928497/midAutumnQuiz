package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.Favor;
import com.yukoon.midautumnquiz.entities.Puzzle;
import com.yukoon.midautumnquiz.services.FavorService;
import com.yukoon.midautumnquiz.services.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class QAController {
    @Autowired
    private PuzzleService puzzleService;
    @Autowired
    private FavorService favorService;

    //获取对象
    @ModelAttribute
    public void getReward(@RequestParam(value = "id",required = false)Integer id,@RequestParam(value = "type",required = false)Integer type, Map<String,Object> map) {
        //若为修改
        if (id !=null) {
           if (type == 1) {
                Puzzle puzzle = puzzleService.findById(id);
                map.put("puzzle",puzzle);
           }
           if (type == 2) {
                Favor favor = favorService.findById(id);
                map.put("favor",favor);
           }
        }
    }

    @GetMapping("/toadd")
    public String toAdd() {
        return "backend/QA_input";
    }

    @PostMapping("/addpuzzle")
    public String addPuzzle(Puzzle puzzle) {
        puzzleService.save(puzzle);
        return "redirect:/todashboard";
    }

    @PutMapping("/editpuzzle")
    public String editPuzzle(Puzzle puzzle) {
        puzzleService.save(puzzle);
        return "redirect:/todashboard";
    }

    @DeleteMapping("/puzzle/{id}")
    public String deletePuzzle(@PathVariable("id")Integer id) {
        puzzleService.delete(id);
        return "redirect:/todashboard";
    }

    @DeleteMapping("/favor/{id}")
    public String deleteFavor(@PathVariable("id")Integer id) {
        favorService.delete(id);
        return "redirect:/todashboard";
    }

    @PostMapping("/addfavor")
    public String addFavor(Favor favor) {
        favorService.save(favor);
        return "redirect:/todashboard";
    }

    @GetMapping("/toeditpuzzle/{id}")
    public String toEditQuiz(@PathVariable("id")Integer id, Map<String,Object> map) {
        Puzzle puzzle  = puzzleService.findById(id);
        map.put("puzzle",puzzle);
        return "backend/QA_input";
    }

    @PutMapping("/editfavor")
    public String editFavor(Favor favor) {
        favorService.save(favor);
        return "redirect:/todashboard";
    }

    @GetMapping("/toeditfavor/{id}")
    public String toEditFavor(@PathVariable("id")Integer id, Map<String,Object> map) {
        Favor favor = favorService.findById(id);
        map.put("favor",favor);
        return "backend/QA_input";
    }
}
