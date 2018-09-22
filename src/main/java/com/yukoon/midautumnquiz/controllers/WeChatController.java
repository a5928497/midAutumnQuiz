package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.entities.Puzzle;
import com.yukoon.midautumnquiz.entities.ShareInfo;
import com.yukoon.midautumnquiz.entities.WeChatConfig;
import com.yukoon.midautumnquiz.services.ShareInfoService;
import com.yukoon.midautumnquiz.services.WeChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class WeChatController {
    @Autowired
    private ShareInfoService shareInfoService;
    @Autowired
    private WeChatService weChatService;

    //获取对象
    @ModelAttribute
    public void getReward(@RequestParam(value = "id",required = false)Integer id, Map<String,Object> map) {
        //若为修改
        if (id !=null) {
            ShareInfo shareInfo = shareInfoService.find();
            map.put("shareInfo",shareInfo);
        }
    }

    @ResponseBody
    @GetMapping("/getwechatconfig")
    public WeChatConfig getAccessToken(@RequestParam("url")String url) {
        ShareInfo shareInfo = shareInfoService.find();
        WeChatConfig weChatConfig = weChatService.signature(url);
        weChatConfig.setTitle(shareInfo.getTitle()).setDesc(shareInfo.getDesc());
        return weChatConfig;
    }

    @ResponseBody
    @GetMapping("/getsharedetails")
    public ShareInfo getActShareDetails() {
        ShareInfo shareInfo = shareInfoService.find();
        return shareInfo;
    }

    @GetMapping("/sharemanager")
    public String toShare(Map<String,Object> map) {
        if (!shareInfoService.isInit()) {
            shareInfoService.init();
        }
        map.put("shareInfo",shareInfoService.find());
        return "backend/share_input";
    }

    @PutMapping("/shareInfo")
    public String editShareInfo(ShareInfo shareInfo) {
        shareInfoService.save(shareInfo);
        return "redirect:/sharemanager";
    }
}
