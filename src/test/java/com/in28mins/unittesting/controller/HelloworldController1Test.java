package com.in28mins.unittesting.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

//@SpringBootTest(classes=HelloworldController.class) - if we are using complete integration testing
@AutoConfigureMockMvc

@WebMvcTest(HelloworldController1.class) //using @WebMvcTest instead of SpringBootTest for testing just web layer
class HelloworldController1Test {
	
	@Autowired 
	private MockMvc mockmvc;
	@MockBean
	private GreetingService service;
	
	@Test
	public void Helloworldbasictest() throws Exception {
		//fail("Not yet implemented");
		//call helloworld
		//Verify helloword 
		RequestBuilder request = MockMvcRequestBuilders
									.get("/helloword")
									.accept(MediaType.APPLICATION_JSON);
		
		StatusResultMatchers status = status();
		MvcResult andReturn = mockmvc.perform(request)
				.andExpect(status.isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		//assertEquals("Hello World", andReturn.getResponse().getContentAsString());4
		//this is not needed when content is verified.
		
		//Another way of comparision
		this.mockmvc.perform(get("/helloword")).andDo(print()).andExpect(status.isOk())
		.andExpect(content().string(containsString("Hello World")));
	}
	
	  @Test 
	  public void greetingsShouldReturnMessageFromService() throws
	  Exception 
	  { 
		  when(service.greet()).thenReturn("Hello, Mock"); 
	  
	  RequestBuilder request = MockMvcRequestBuilders 
			  .get("/greeting") 
	  .accept(MediaType.APPLICATION_JSON); 
	  
	  MvcResult andReturn1 = mockmvc.perform(request).andReturn(); 
	  assertEquals("Hello, Mock", andReturn1.getResponse().getContentAsString()); 
	  }
	 }
