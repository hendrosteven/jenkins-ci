package com.uangteman;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.uangteman.entity.Category;
import com.uangteman.repo.CategoryRepo;
import com.uangteman.service.Matematika;
import com.uangteman.service.UserService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoJpaApplication.class, 
	webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoJpaApplicationTests {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	@LocalServerPort
	int port;
	
	@Test
	public void testGetCategory(){
		ResponseEntity<ArrayList> entity = this.testRestTemplate
				.getForEntity("http://localhost:"+this.port+"/category",
						ArrayList.class);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
	}


}
