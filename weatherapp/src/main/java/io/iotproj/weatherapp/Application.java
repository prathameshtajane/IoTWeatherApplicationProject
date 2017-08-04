package io.iotproj.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.AbstractEnvironment;

import io.iotproj.weatherapp.config.SwaggerConfig;
import io.iotproj.weatherapp.config.WebConfig;

@SpringBootApplication
@EnableWebMvc
@ComponentScan
@Import({ WebConfig.class, SwaggerConfig.class })
public class Application extends WebMvcConfigurerAdapter{
	public static void main(String args[]){
	SpringApplication.run(Application.class,args);
	}
	
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
