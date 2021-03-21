package com.entelgy.retoback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream; 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.entelgy.retoback.controller.ApiController;
import com.entelgy.retoback.entity.Comment;
import com.entelgy.retoback.repo.ApiRepo;
import com.entelgy.retoback.service.ApiService;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
class RetobackApplicationTests {

    @InjectMocks
    ApiController apiController;
    
    @InjectMocks
    ApiService apiService;
    
	@Mock
	ApiService service;
    
    @Mock
    ApiRepo apiRepo;
    
    
    @Test
    void testResponseController() {
    	//Verificando el response del RestController
    	MockHttpServletRequest request = new MockHttpServletRequest();
    	RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    	ResponseEntity<Map> responseEntity = (ResponseEntity<Map>) apiController.reestructure();
    	
    	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    
    @Test
    void testApiService() {
    	// Simulando una cantidad de registros asignados para el apiRepo (origen de los datos) 
    	Mockito.when(apiRepo.getComments()).thenReturn(Stream.of(new Comment(0, 1, "nombre", "email@test,com", "comment..")).collect(Collectors.toList()));
    	//El apiService (reestructuración) retorna la cantidad de registros asignada
    	//Se agreg 1 registro la cual el service debe contener la misma cantidad.
    	assertEquals(1, apiService.listReestructure().size());
    }
    

}
