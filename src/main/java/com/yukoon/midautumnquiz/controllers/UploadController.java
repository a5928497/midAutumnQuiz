package com.yukoon.midautumnquiz.controllers;

import com.yukoon.midautumnquiz.config.PathConfig;
import com.yukoon.midautumnquiz.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class UploadController {
    @Autowired
    private PathConfig pathConfig;

    //后台前往分享缩略图上传
    @GetMapping("/touploadshareimg")
    public String toUploadShareImg(Map<String,Object> map, String uploadMsg) {
        if (uploadMsg != null) {
            map.put("uploadMsg",uploadMsg);
        }
        return "backend/share_img_upload";
    }

    //后台分享缩略图上传
    @PostMapping("/shareimgupload")
    public String uploadShareImg(@RequestParam("pic")MultipartFile pic, HttpServletRequest request
            , Integer act_id, RedirectAttributes attributes){
        String filePath = pathConfig.getShareImgPath();
        String fileName = pic.getOriginalFilename();
        String uploadMsg = "图片上传成功!";
        if (!FileUtil.isImg(fileName)){
            uploadMsg = "该文件不是图片格式,请重新上传!";
            attributes.addFlashAttribute("uploadMsg",uploadMsg);
            return "redirect:/touploadshareimg";
        }
        //重命名文件
        fileName = "share.png";
        try {
            //上传图片
            FileUtil.uploadFile(pic.getBytes(),filePath,fileName);
            //压缩图片
            FileUtil.resizeImg(filePath+fileName,150,150);
        }catch (Exception e) {
            uploadMsg = "图片上传出现错误,请重新上传!";
            attributes.addFlashAttribute("uploadMsg",uploadMsg);
            return "redirect:/touploadshareimg";
        }
        attributes.addFlashAttribute("uploadMsg",uploadMsg);
        return "redirect:/touploadshareimg";
    }
}
