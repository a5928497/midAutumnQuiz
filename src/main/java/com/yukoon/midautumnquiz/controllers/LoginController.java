package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.User;
import com.yukoon.midautumnquiz.services.FavorService;
import com.yukoon.midautumnquiz.services.PuzzleService;
import com.yukoon.midautumnquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private PuzzleService puzzleService;
	@Autowired
	private FavorService favorService;

	@GetMapping("/backend")
	public String toBackend() {
		//第一次访问初始化后台
		if (!userService.isInit()) {
			User user = new User();
			user.setUsername("admin").setPassword("admin");
			userService.save(user);
		}
		return "backend/backend";
	}

	@PostMapping("/login")
	public String login(User user, Map<String,Object> map) {
		boolean result = userService.login(user);
		if (result) {
			map.put("puzzles",puzzleService.findAll());
			map.put("favors",favorService.findAll());
			return "backend/dashboard";
		}
		return "redirect:/backend";
	}
}
