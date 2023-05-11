package com.github.bwar.sb.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikiMediaConsumer.class);
	
	@KafkaListener(topics="wikimedia_recentchange",
			groupId = "myGroup")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("event message received -> %s", eventMessage));
	}
	
}
