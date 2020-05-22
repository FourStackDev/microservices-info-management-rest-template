package org.fourstack.microservices.infomanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InfoBeansConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
