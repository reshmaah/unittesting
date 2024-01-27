package com.in28mins.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

import com.in28mins.unittesting.data.ItemRepository;;
//import org.springframework.test.context.junit4.SpringRunner;
//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
//SpringbootTest searches for springbootapplication in current package, or parent package and launches complete application and lauches inmemory DB as well
//as well as source resources as well.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//Run application on random available port
//@TestPropertySource(locations= {"classpath:test-configuration.properties"})
public class ItemControllerIntegrationTest {
	@Autowired
	private TestRestTemplate testrestTemplate; //this lauches application on random port
	@MockBean
	ItemRepository itemrepository;
	
	@Test
	public void contextLoad() throws JSONException
	{
		String actual = "[{id:1000},{id:1002},{id:1004}]";
		String response = this.testrestTemplate.getForObject("/listofitems", String.class);
		JSONAssert.assertEquals("[{id:1000},{id:1002},{id:1004}]", actual, false);
		
	}
}
