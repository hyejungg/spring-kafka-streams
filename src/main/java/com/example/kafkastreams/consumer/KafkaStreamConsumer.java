package com.example.kafkastreams.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaStreamConsumer {

	/**
	 * test 토픽으로 받은 데이터를 가공하여 새로운 토픽으로 들어왔는지 확인
	 * @param message
	 */
	@KafkaListener(id = "test-streams-id", groupId = "test-group", topics = "test-to")
	public void listen(String message) {
		log.info("[Consumer] test-to message = {}", message);
	}
}
