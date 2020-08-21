package com.ganesh.restfulconsumersample.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ganesh.restfulconsumersample.beans.PersonV1;
import com.ganesh.restfulconsumersample.beans.PersonV2;

@RestController
public class ConsumerController {

	private Logger logger = LoggerFactory.getLogger(getClass());

//	@Autowired
//	private ProducerService proxy;

	@GetMapping("/person/v1v1")
	public PersonV1 fetchPersonv1v1() {
		Map<String, String> uriVariables = new HashMap<String, String>();
		ResponseEntity<PersonV1> responseEntity = new RestTemplate().getForEntity("http://localhost:8020/v1/person",
				PersonV1.class, uriVariables);

		PersonV1 person = responseEntity.getBody();

		logger.info(" person = {}  ", person);

		return person;
	}

	@GetMapping("/person/v1v2")
	public PersonV1 fetchPersonv1v2() {
		Map<String, String> uriVariables = new HashMap<String, String>();
		ResponseEntity<PersonV1> responseEntity = new RestTemplate().getForEntity("http://localhost:8020/v2/person",
				PersonV1.class, uriVariables);

		PersonV1 person = responseEntity.getBody();

		logger.info(" person = {}  ", person);

		return person;
	}

	@GetMapping("/person/v2v1")
	public PersonV2 fetchPersonv2v1() {
		Map<String, String> uriVariables = new HashMap<String, String>();
		ResponseEntity<PersonV2> responseEntity = new RestTemplate().getForEntity("http://localhost:8020/v1/person",
				PersonV2.class, uriVariables);

		PersonV2 person = responseEntity.getBody();

		logger.info(" person = {}  ", person);

		return person;
	}

	@GetMapping("/person/v2v2")
	public PersonV2 fetchPersonv2v2() {
		Map<String, String> uriVariables = new HashMap<String, String>();
		ResponseEntity<PersonV2> responseEntity = new RestTemplate().getForEntity("http://localhost:8020/v2/person",
				PersonV2.class, uriVariables);

		PersonV2 person = responseEntity.getBody();

		logger.info(" person = {}  ", person);

		return person;
	}
}
