package com.yukoon.midautumnquiz.services;

import com.yukoon.midautumnquiz.entities.Favor;
import com.yukoon.midautumnquiz.repo.FavorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class FavorService {
	@Autowired
	private FavorRepo favorRepo;

	//删除
	@Transactional
	public void delete(Integer id){
		favorRepo.delete(id);
	}

	//保存favor
	@Transactional
	public void save(Favor favor) {
		favorRepo.saveAndFlush(favor);
	}

	//查找favor
	public Favor findById(Integer id) {
		return favorRepo.findOne(id);
	}

	//查询所有爱好问题
	@Transactional
	public List<Favor> findAll() {
		List<Favor> list = favorRepo.findAll();
		return list;
	}

	//查询第一个爱好问题
	public Favor findFirst() {
		List<Favor> list = findAll();
		Favor favor = null;
		if (list.size() >0 && null != list) {
			favor = list.get(0);
			for (Favor tmp : list) {
				if (tmp.getOrder() < favor.getOrder()){
					favor = tmp;
				}
			}
		}
		return favor;
	}

	public List<Favor> sortAll() {
		List<Favor> favors = findAll();
		Collections.sort(favors, new Comparator<Favor>() {
			@Override
			public int compare(Favor o1, Favor o2) {
				boolean flag = o1.getOrder() > o2.getOrder();
				if (flag) {
					return 1;
				}
				return -1;
			}
		});
		return favors;
	}

	public Favor getNextFavor(Integer order) {
		List<Favor> favors = sortAll();
		Favor favor = null;
		for (int i =0;i<favors.size();i++) {
			if (favors.get(i).getOrder() == order) {
				return favors.get(i+1);
			}
		}
		return favor;
	}
}
