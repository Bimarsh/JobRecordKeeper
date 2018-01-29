package com.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import com.job.reports.ExcelView;
import com.job.reports.ExcelViewResolver;

@SpringBootApplication
public class JobRecordKeeperApplication {

	@Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }
	public static void main(String[] args) {
		SpringApplication.run(JobRecordKeeperApplication.class, args);
	}
	 @Bean
	    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
	        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
	        resolver.setContentNegotiationManager(manager);

	        // Define all possible view resolvers
	        List<ViewResolver> resolvers = new ArrayList<>();

	      
	        resolvers.add(excelViewResolver());
	       

	        resolver.setViewResolvers(resolvers);
	        return resolver;
	    }
}
