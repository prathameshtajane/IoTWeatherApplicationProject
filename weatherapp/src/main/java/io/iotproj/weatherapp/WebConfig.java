package io.iotproj.weatherapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.ComponentScan;


@Configuration
@ComponentScan
@EnableWebMvc
/*
* @EnableWebMvc makes the application recongnize httpRequest,httpResponse,http Sessions
* This will make the application understand that it will not have main method
* and it will be deployed on the ServletContainer
* */
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
    public void addCorsMappings(CorsRegistry registry) {
	
        registry.addMapping("/**")
                .allowedOrigins("http://mocker.egen.io")
                .allowedMethods("OPTIONS","PUT", "DELETE","POST","GET","PATCH")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .exposedHeaders("Access-Control-Allow-Origin:*");
    }
}

