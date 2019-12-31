package com.example.demoFeign.CAP;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;

import java.util.function.UnaryOperator;

public class CAPClientConfig {

	//@Bean
	//public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
	//	return new FeignErrorDecoder("CAP", objectMapper);

	UnaryOperator<String> u1 = String::toLowerCase;
	}

