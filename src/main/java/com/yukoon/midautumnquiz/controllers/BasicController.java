package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.User;
import com.yukoon.midautumnquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BasicController {
	@Autowired
	private UserService userService;

	//获取对象
	@ModelAttribute
	public void getReward(@RequestParam(value = "id",required = false)Integer id, Map<String,Object> map) {
		//若为修改
		if (id !=null) {
			User user = userService.getUser();
			map.put("user",user);
		}
	}

	@GetMapping("/index")
	public String toIndex() {
		return "public/index";
	}

	@GetMapping("/account")
	public String toEditAccount(Map<String,Object> map) {
		map.put("user",userService.getUser());
		return "backend/user_input";
	}

	@PutMapping("/account")
	public String editAccount(User user) {
		userService.save(user);
		return "redirect:/todashboard";
	}
}
