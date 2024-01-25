package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 첨부 파일의 경로를 맵핑하기 위한 설정 클래스 => 동작시에 설정 클래스 먼저 작동 된 후에 다른 일반 클래스들 작동됨
 * */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${webpath}") // application.properties에 임의로 설정한 설정을 value= 를 통해 불러옴
	String webpath; //첨부 폴더 경로 -> 여기에 webpath=file:/C:\\uploadfile\\ 안적고 application.properties에 적은 이유는, 변경 용이 하기 위해서 이다.

	//스프링 보안문제로 외부폴더에 바로 접근할수 없음 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {	
		//폴더와 상대경로 맵핑
		registry.addResourceHandler("/uploadfile/**").addResourceLocations(webpath); 
										// 상대경로								//절대 경로 => 상대경로를 절대경로로 치환시켜주겠다.
																					//  == file:/C:\\uploadfile\\
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}
