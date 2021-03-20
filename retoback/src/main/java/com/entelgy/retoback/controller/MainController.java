package com.entelgy.retoback.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.entelgy.retoback.entity.Comment;


@RestController
@RequestMapping("/api")
public class MainController {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.base.url}")
	private String baseRestURL; 
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/reestructure")
	public ResponseEntity<?> reestructure() {
		Map<String, List<String>> mapCom= new HashMap();
		Comment[] comments = restTemplate.getForObject(baseRestURL, Comment[].class);
		
		List<String> items= new ArrayList<>();
		Arrays.asList(comments).stream().forEach(c->{
			items.add(c.getPostID()+"|"+c.getId()+"|"+c.getEmail());
		});
		mapCom.put("data", items);
		return new ResponseEntity<Map>( mapCom , HttpStatus.OK); 
	}
}
