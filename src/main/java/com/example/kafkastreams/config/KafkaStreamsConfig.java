package com.example.kafkastreams.config;

import static org.apache.kafka.streams.StreamsConfig.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfig {

	@Value(value = "${spring.kafka.streams.application-id}")
	private String applicationId;
	@Value(value = "${spring.kafka.streams.bootstrap-servers}")
	private String bootstrapAddress;

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	KafkaStreamsConfiguration defaultKafkaStreamsConfig() {
		Map<String, Object> props = new HashMap<>();
		props.put(APPLICATION_ID_CONFIG, applicationId);
		props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

		return new KafkaStreamsConfiguration(props);
	}
}
