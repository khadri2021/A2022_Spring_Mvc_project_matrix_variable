package com.khadri.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.khadri.spring.mvc" })
public class AppConfig  implements WebMvcConfigurer {
 
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper helper = new UrlPathHelper();
		helper.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(helper);
	}
}
