package com.yukoon.midautumnquiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	@GetMapping("/index")
	public String toIndex() {
		return "public/index";
	}
	@GetMapping("/test")
	public String test() {
		return "public/game";
	}
}
