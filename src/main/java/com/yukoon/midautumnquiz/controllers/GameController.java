package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.Favor;
import com.yukoon.midautumnquiz.entities.Puzzle;
import com.yukoon.midautumnquiz.entities.Record;
import com.yukoon.midautumnquiz.entities.Result;
import com.yukoon.midautumnquiz.services.FavorService;
import com.yukoon.midautumnquiz.services.PuzzleService;
import com.yukoon.midautumnquiz.services.RecordService;
import com.yukoon.midautumnquiz.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GameController {
    @Autowired
    private PuzzleService puzzleService;
    @Autowired
    private FavorService favorService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private RecordService recordService;

    @GetMapping("/togame")
    public String toGame(Map<String,Object> map) {
        Puzzle puzzle = puzzleService.findFirst();
        map.put("firstPuzzle",puzzle);
        map.put("puzzleSize",puzzleService.findAll().size());
        return "public/game";
    }

    @ResponseBody
    @GetMapping("/getnextpuzzle/{order}")
    public Puzzle getNextPuzzle(@PathVariable("order")Integer order) {
        return puzzleService.getNextPuzzle(order);
    }

    @ResponseBody
    @GetMapping("/getfirstfavor")
    public Favor getFirstFavor() {
        Favor favor =  favorService.findFirst();
        favor.setSize(favorService.findAll().size());
        return favor;
    }

    @ResponseBody
    @GetMapping("/getnextfavor/{order}")
    public Favor getNextFavor(@PathVariable("order")Integer order) {
        return favorService.getNextFavor(order);
    }


    @GetMapping("/getresult/{belongTo}")
    public String getResult(@PathVariable("belongTo")Integer belongTo) {
        Result result =  resultService.getRandomResultByBelongTo(belongTo);
        Record record = recordService.save(result);
        return "redirect:/record/" + record.getId();
    }

    @GetMapping("/record/{id}")
    public String toRecord(@PathVariable("id")Integer id,Map<String,Object> map) {
        Result result = recordService.findById(id).getResult();
        map.put("result",result);
        return "public/result";
    }
}
