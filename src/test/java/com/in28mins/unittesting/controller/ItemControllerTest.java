package com.in28mins.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

//import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import com.in28mins.unittesting.model.Item;
import com.in28mins.unittesting.service.ItemFromBusinessService;

//@SpringBootTest(classes=HelloworldController.class) - if we are using complete integration testing
@AutoConfigureMockMvc

@WebMvcTest(ItemController.class) //using @WebMvcTest instead of SpringBootTest for testing just web layer
class ItemControllerTest {
	
	@Autowired 
	private MockMvc mockmvc;
	@MockBean
	private ItemFromBusinessService businessService;
	@MockBean
	private GreetingService greetingService;
	
	@Test
	public void ItemControllerbasictest() throws Exception {
		//fail("Not yet implemented");
		//call helloworld
		//Verify helloword 
		RequestBuilder request = MockMvcRequestBuilders
									.get("/dummy-item")
									.accept(MediaType.APPLICATION_JSON);
		
		StatusResultMatchers status = status();
		MvcResult andReturn = mockmvc.perform(request)
				.andExpect(status.isOk())
				//.andExpect(content().string("{\"qty\":5,\"price\":10,\"name\":\"Ball\",\"id\":1}"))
				.andReturn();
		//assertEquals("Hello World", andReturn.getResponse().getContentAsString());4
		//this is not needed when content is verified.
		
		//Another way of comparision
		this.mockmvc.perform(get("/dummy-item")).andDo(print()).andExpect(status.isOk())
		.andExpect(content().json("{\"qty\":5,\"price\":10,\"name\":\"Ball\",\"id\":1}"));
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false)
	//.json validation is better as it does noot validate string as is, if validated keys and values are correct, and partial JSON values can also be vlidated , need not have all keys in response matching, even it works if additional fields are prepsent
	}
	
	@Test
	public void itemfromBusinessServicebasictest() throws Exception {
		//fail("Not yet implemented");
		//call helloworld
		//Verify helloword 
		RequestBuilder request = MockMvcRequestBuilders
									.get("/itemfromBusinessService")
									.accept(MediaType.APPLICATION_JSON);
		
		StatusResultMatchers status = status();
		when(businessService.item()).thenReturn(new Item(2,"item2",1,10));
		MvcResult andReturn = mockmvc.perform(request)
				.andExpect(status.isOk())
				//.andExpect(content().string("{\"qty\":1,\"price\":10,\"name\":\"item2\",\"id\":2}"))
				.andReturn();
		//assertEquals("Hello World", andReturn.getResponse().getContentAsString());4
		//this is not needed when content is verified.
		
		//Another way of comparision
		this.mockmvc.perform(get("/itemfromBusinessService")).andDo(print()).andExpect(status.isOk())
		.andExpect(content().json("{\"qty\":1,\"price\":10,\"name\":\"item2\",\"id\":2}"));
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false)
	//.json validation is better as it does noot validate string as is, if validated keys and values are correct, and partial JSON values can also be vlidated , need not have all keys in response matching, even it works if additional fields are prepsent
	}
	@Test
	public void retriveAllItemsest() throws Exception { //we want to stub business service
		//fail("Not yet implemented");
		//call helloworld
		//Verify helloword 
		//mocking database fetch mocking DB
		//mocking data layer and testing businessservice
		RequestBuilder request = MockMvcRequestBuilders
									.get("/listofitems")
									.accept(MediaType.APPLICATION_JSON);
		when(businessService.retriveallItems()).thenReturn(Arrays.asList(new Item(2,"black", 10, 20),new Item(3,"black", 10, 20)));
		StatusResultMatchers status = status();
		MvcResult andReturn = mockmvc.perform(request)
				.andExpect(status.isOk())
				.andExpect(content().json("[{qty:20,price:10,name:black,id:2},{qty:20,price:10,name:black,id:3}]"))
				.andReturn();
		//assertEquals("Hello World", andReturn.getResponse().getContentAsString());4
		//this is not needed when content is verified.
		
		/*
		 * //Another way of comparision
		 * this.mockmvc.perform(get("/dummy-item")).andDo(print()).andExpect(status.isOk
		 * ()) .andExpect(content().json(
		 * "{\"qty\":5,\"price\":10,\"name\":\"Ball\",\"id\":1}"));
		 * //JSONAssert.assertEquals(expected,
		 * result.getResponse().getContentAsString(), false)
		 */	//.json validation is better as it does noot validate string as is, if validated keys and values are correct, and partial JSON values can also be vlidated , need not have all keys in response matching, even it works if additional fields are prepsent
	}
	
}
