package com.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;





@SpringBootApplication
public class JobRecordKeeperApplication {

	
	@RequestMapping("/")
    @ResponseBody
    String home() {
		System.out.println("Hello World");
      return "Hello World!";
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(JobRecordKeeperApplication.class, args);
	}
}
