package com.orion282.calculatorhazelcast;

import com.hazelcast.client.config.ClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;



/**
 * Main Spring Application
 */
@SpringBootApplication
@EnableCaching
public class CalculatorHazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorHazelcastApplication.class, args);
	}

	@Bean
	public ClientConfig hazelcastClientConfig() {
		ClientConfig clientConfig = new ClientConfig();
                clientConfig.getNetworkConfig().addAddress("172.17.0.4");
                return clientConfig;
	}
}
