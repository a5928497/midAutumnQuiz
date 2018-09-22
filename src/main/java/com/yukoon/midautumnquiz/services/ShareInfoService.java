package com.yukoon.midautumnquiz.services;

import com.yukoon.midautumnquiz.entities.ShareInfo;
import com.yukoon.midautumnquiz.repo.ShareInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShareInfoService {
    @Autowired
    private ShareInfoRepo shareInfoRepo;

    public boolean isInit() {
        boolean flag = true;
        if (shareInfoRepo.findAll().size() == 0) {
            flag = false;
        }
        return flag;
    }

    @Transactional
    public void init() {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setTitle("未添加").setDesc("未添加");
        shareInfoRepo.saveAndFlush(shareInfo);
    }

    @Transactional
    public void save(ShareInfo shareInfo) {
        shareInfoRepo.saveAndFlush(shareInfo);
    }

    public ShareInfo find() {
        return shareInfoRepo.findOne(1);
    }
}
