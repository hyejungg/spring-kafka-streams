package com.example.kafkastreams;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @EnableKafka
@SpringBootApplication
public class KafkaStreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamsApplication.class, args);
	}

	/**
	 * 테스트용 카프카 프로듀서
	 * @param kafkaTemplate
	 * @return
	 */
	@Bean
	public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate) {
		AtomicInteger num = new AtomicInteger(1);
		log.debug("@@ im application runner!!!!!");
		return args -> {
			while (true) {
				kafkaTemplate.send("test", String.format("%s %s", num, "test-message!!.."));
				Thread.sleep(1000);
				num.getAndIncrement();
			}
		};
	}
}
