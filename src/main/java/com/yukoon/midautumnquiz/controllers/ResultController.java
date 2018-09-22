package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.Result;
import com.yukoon.midautumnquiz.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ResultController {
    @Autowired
    private ResultService resultService;

    //获取对象
    @ModelAttribute
    public void getReward(@RequestParam(value = "id",required = false)Integer id, Map<String,Object> map) {
        //若为修改
        if (id !=null) {
            Result result = resultService.findById(id);
            map.put("result",result);
        }
    }

    @GetMapping("/poets")
    private String toPoet(Map<String,Object> map) {
        List<Result> list = resultService.findAll();
        map.put("poets",list);
        return "backend/poet_list";
    }

    @GetMapping("/poet")
    private String toAdd() {
        return "backend/poet_input";
    }

    @DeleteMapping("/poet/{id}")
    public String delete(@PathVariable("id")Integer id) {
        resultService.delete(id);
        return "redirect:/poets";
    }

    @PostMapping("/poet")
    public String add(Result result) {
        resultService.save(result);
        return "redirect:/poets";
    }

    @PutMapping("/poet")
    public String edit(Result result) {
        resultService.save(result);
        return "redirect:/poets";
    }

    @GetMapping("/poet/{id}")
    private String toAdd(@PathVariable("id")Integer id,Map<String,Object> map) {
        Result result = resultService.findById(id);
        map.put("poet",result);
        return "backend/poet_input";
    }
}
