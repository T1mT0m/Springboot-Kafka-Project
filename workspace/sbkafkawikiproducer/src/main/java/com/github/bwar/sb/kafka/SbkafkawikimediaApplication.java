package com.github.bwar.sb.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.bwar.sb.kafka.producer.WikimediaProducer;

@SpringBootApplication
public class SbkafkawikimediaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SbkafkawikimediaApplication.class, args);
	}
	
	@Autowired
	private WikimediaProducer wikimediaProducer;

	@Override
	public void run(String... args) throws Exception {
		
		wikimediaProducer.sendMessage();
		
	}
	
	

}
