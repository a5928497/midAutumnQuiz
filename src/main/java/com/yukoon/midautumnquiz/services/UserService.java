package com.yukoon.midautumnquiz.services;

import com.yukoon.midautumnquiz.entities.User;
import com.yukoon.midautumnquiz.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	public boolean login(User user) {
		User tmp = userRepo.findByUsername(user.getUsername());
		boolean flag = false;
		if (tmp.getUsername().equals(user.getUsername()) && tmp.getPassword().equals(user.getPassword())) {
			flag = true;
		}
		return  flag;
	}

	public boolean isInit() {
		boolean flag = true;
		if (userRepo.findAll().size() == 0) {
			flag = false;
		}
		return flag;
	}

	public void save(User user) {
		userRepo.saveAndFlush(user);
	}
}
