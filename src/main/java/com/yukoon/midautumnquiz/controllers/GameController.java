package com.yukoon.midautumnquiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GameController {
    @GetMapping("/togame")
    public String toGame(Map<String,Object> map) {
        return "public/game";
    }
}
