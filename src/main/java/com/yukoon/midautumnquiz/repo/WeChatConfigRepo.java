package com.yukoon.midautumnquiz.repo;

import com.yukoon.midautumnquiz.entities.WeChatConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WeChatConfigRepo extends JpaRepository<WeChatConfig,Integer>{

}
