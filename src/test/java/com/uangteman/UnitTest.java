package com.uangteman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uangteman.entity.Category;
import com.uangteman.repo.CategoryRepo;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UnitTest {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Test	
	public void categoryTest(){
		Category category = new Category();
		category.setName("Sample");
		
		Category result = categoryRepo.save(category);
		Assert.assertNotNull(result);
		
		result.setName("Sample Update");
		result = categoryRepo.save(result);
		Assert.assertEquals("Sample Update", result.getName());
		
		categoryRepo.delete(result);
		Assert.assertEquals(null, categoryRepo.findOne(result.getId()));
	}
	
}
