package com.in28mins.unittesting.unittesting.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28mins.unittesting.data.ItemRepository;
import com.in28mins.unittesting.model.Item;
//THis lauches springcontext , no need to write RunWith(SpringRunner.class) in JUnit5
//@DataJdbcTest  //this is intelligent and mocks inmemory database so that we can write unittest Why is this not working and giving error java.lang.ClassNotFoundException: org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
//replacing @SpringBootTest with DataJdbcTestis working fine
@SpringBootTest  
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;
	
	@Test
	public void testFindAll()
	{
		List<Item> items= repository.findAll();
		assertEquals(3, items.size());
	}
	
}
