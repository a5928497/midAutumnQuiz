package com.yukoon.midautumnquiz.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "pathconfig")
@PropertySource("classpath:pathconfig.yml")

public class PathConfig extends WebMvcConfigurerAdapter {


	@Getter
	@Setter
	@Value("${shareImgPath}")
	private String shareImgPath;
	@Getter
	@Setter
	@Value("${poetImgPath}")
	private String poetImgPath;
	@Resource(name="thymeleafViewResolver")
	private ThymeleafViewResolver thymeleafViewResolver;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		if (thymeleafViewResolver != null) {
			Map<String,Object> map = new HashMap<>();
			map.put("shareImgPath",shareImgPath);
			map.put("poetImgPath",poetImgPath);
			thymeleafViewResolver.setStaticVariables(map);
		}
		super.configureViewResolvers(registry);
	}

	//配置前台显示图片、广告图片映射路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/share_images/**").addResourceLocations("file:"+shareImgPath);
		registry.addResourceHandler("/poet_images/**").addResourceLocations("file:"+poetImgPath);
        super.addResourceHandlers(registry);
    }

}
