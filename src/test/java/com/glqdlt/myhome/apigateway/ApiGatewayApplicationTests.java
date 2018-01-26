package com.glqdlt.myhome.apigateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiGatewayApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(ApiGatewayApplicationTests.class);


	public ApiGatewayApplicationTests() {
		this.restTemplate = new RestTemplateBuilder().build();
	}

	RestTemplate restTemplate;


	@Test
	public void contextLoads() {
	}


	@Test
	public void delivaryUpload(){

	}

	@Test
	public void delivaryDownload(){
//		this.restTemplate.getForEntity("http://127.0.0.1:38080/book/download/1", ByteArrayResource.class);
		ResponseEntity<?> responseEntity = this.restTemplate.getForEntity("http://127.0.0.1:38080/book/download/1", ByteArrayResource.class);
		log.info(responseEntity.toString());
		log.info(responseEntity.getHeaders().toString());
		log.info((responseEntity.getBody().toString()));
	}


}
