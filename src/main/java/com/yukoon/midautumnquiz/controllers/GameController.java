package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.Favor;
import com.yukoon.midautumnquiz.entities.Puzzle;
import com.yukoon.midautumnquiz.services.FavorService;
import com.yukoon.midautumnquiz.services.PuzzleService;
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
}
