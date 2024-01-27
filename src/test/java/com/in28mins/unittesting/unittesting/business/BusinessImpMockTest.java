package com.in28mins.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28mins.unittesting.data.ItemRepository;
import com.in28mins.unittesting.model.Item;
import com.in28mins.unittesting.service.ItemFromBusinessService;
import com.in28mins.unittesting.unittesting.someDataService;

@ExtendWith(MockitoExtension.class) //@RunWith(MokitoJunitRunnier.class) of JUnit4
class BusinessImpMockTest {
	@InjectMocks
	ItemFromBusinessService impl = new ItemFromBusinessService();
	@Mock
	ItemRepository repository;
    //mocking data layer and testing businessservice

	/*//This is no more needed when you run with MokitoExtension.class
	 * @BeforeEach public void before() { impl.setDataservice(dataservicemock2); }
	 */
	@Test
	void calsumfromDataService_basic() {
		//fail("Not yet implemented");
		//dataservicemock2 getAllData()  new int[] {1,2,3} //interface implementastion methods
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"black", 10, 20),new Item(3,"black", 10, 20)));
		//impl.setDataservice(dataservicemock2);
		List<Item> items = impl.retriveallItems();
		assertEquals(200, items.get(0).getValue());
	}
	}
