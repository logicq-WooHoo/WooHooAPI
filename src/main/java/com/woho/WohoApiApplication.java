package com.woho;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.woho.service.StorageService;

@SpringBootApplication
public class WohoApiApplication implements CommandLineRunner {

	@Resource
	StorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(WohoApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}
