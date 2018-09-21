package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.Puzzle;
import com.yukoon.midautumnquiz.services.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GameController {
    @Autowired
    private PuzzleService puzzleService;

    @GetMapping("/togame")
    public String toGame(Map<String,Object> map) {
        Puzzle puzzle = puzzleService.findFirst();
        map.put("firstPuzzle",puzzle);
        return "public/game";
    }
}
