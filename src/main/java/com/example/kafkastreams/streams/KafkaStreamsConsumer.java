package com.example.kafkastreams.streams;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaStreamsConsumer {

	@Bean
	public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
		KStream<String, String> stream = streamsBuilder.stream("test");
		stream
			.peek(((key, value) -> log.info("[Stream] Message = " + value)))  // return 없이 종료
			.map(((key, value) -> KeyValue.pair(key, value.replaceAll("[^0-9]", "")))) // 숫자만 뽑아서 key-value 데이터로 생성
			.to("test-to");
		return stream;
	}
}
