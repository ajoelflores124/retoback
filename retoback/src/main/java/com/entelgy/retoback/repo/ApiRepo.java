package com.entelgy.retoback.repo;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.entelgy.retoback.entity.Comment;

@PropertySource("classpath:application.properties")
@Repository
public class ApiRepo {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Value("${rest.base.url}")
	private String baseRestURL; 
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Comment> getComments() {
		Comment[] comments = restTemplate.getForObject(baseRestURL, Comment[].class);
		return Arrays.asList(comments);
	}
	
}
