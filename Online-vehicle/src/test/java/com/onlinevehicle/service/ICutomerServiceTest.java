package com.onlinevehicle.service;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinevehicle.entity.Customer;
@SpringBootTest
class ICutomerServiceTest {

	@Mock
	private CustomerServiceImpl customerServiceImpl ;

	@Test
	public void addCustomer() throws Exception {
		Customer c = new Customer();
		c.setUserId(2);
		c.setFirstName("Ganesh");
		c.setAddress("Banglore");
		c.setEmail("Ganesh@gmail.com");
		c.setLastName("Choudry");
		c.setMobileNumber("9900123123");
		c.setPassword("123456");
		c.setRole("Customer");
		assertEquals(c, customerServiceImpl.addCustomer(c));
	}
	@Test 
	public void removeCustomer() throws Exception 
	{ 
	Customer c = new Customer(); 
	c.setUserId(10); c.setFirstName("Ganesh"); 
	c.setAddress("Banglore"); 
	c.setEmail("Ganesh@gmail.com"); 
	c.setLastName("Choudry"); 
	c.setMobileNumber("9900123123"); 
	c.setPassword("123456"); 
	c.setRole("Customer"); 
	customerService.addCustomer(c); 
	assertEquals("Deleted Customer",customerService.removeCustomer(c)); 
	}
	
	@Test 
	public void updaeCustomer() throws Exception 
	{ 
	Customer c = new Customer(); 
	c.setUserId(10); 
	c.setFirstName("Ganesh"); 
	c.setAddress("Banglore"); 
	c.setEmail("Ganesh@gmail.com"); 
	c.setLastName("Choudry"); 
	c.setMobileNumber("9900123123"); 
	c.setPassword("123456"); 
	c.setRole("Customer"); 
	customerService.addCustomer(c); 
	Customer c1 = new Customer(); 
	c1.setUserId(10); 
	c1.setFirstName("Suresh"); 
	c1.setAddress("Bangladesh"); 
	c1.setEmail("Ganesh@gmail.com"); 
	c1.setLastName("Choudry"); 
	c1.setMobileNumber("9900123123"); 
	c1.setPassword("123456"); 
	c1.setRole("Customer"); 
	assertEquals(c1, customerService.updaeCustomer(c)); 
	}
	

}
