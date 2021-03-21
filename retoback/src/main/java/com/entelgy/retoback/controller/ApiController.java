package com.entelgy.retoback.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entelgy.retoback.service.IApiService;


@RestController
@RequestMapping("/api")
public class ApiController {
 	
	@Autowired
	private IApiService apiService;
	 
	@SuppressWarnings({ "rawtypes" })
	@PostMapping("/reestructure")
	public ResponseEntity<Map> reestructure() {
		Map<String, List<String>> mapCom= new HashMap<>();
		try {
			mapCom.put("data", apiService.listReestructure());
			return new ResponseEntity<Map>( mapCom , HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map>(new HashMap<>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
