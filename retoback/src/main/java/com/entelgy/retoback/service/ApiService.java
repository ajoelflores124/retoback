package com.entelgy.retoback.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entelgy.retoback.repo.ApiRepo;


@Service
public class ApiService implements IApiService{
	
	@Autowired
	ApiRepo apiRepo;
	
	@Override
	public List<String> listReestructure(){
		List<String> items= new ArrayList<>();
		apiRepo.getComments().stream().forEach(c->
			items.add(c.getPostID()+"|"+c.getId()+"|"+c.getEmail())
		);
		
		return items;
	}
	
}
