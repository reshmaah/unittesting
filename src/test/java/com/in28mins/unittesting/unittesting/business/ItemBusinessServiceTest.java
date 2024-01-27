package com.in28mins.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28mins.unittesting.unittesting.BusinessImpl;
import com.in28mins.unittesting.unittesting.someDataService;

@ExtendWith(MockitoExtension.class) //@RunWith(MokitoJunitRunnier.class) of JUnit4
class ItemBusinessServiceTest {
	@InjectMocks
	BusinessImpl impl = new BusinessImpl();
	@Mock
	someDataService dataservicemock2;

	/*//This is no more needed when you run with MokitoExtension.class
	 * @BeforeEach public void before() { impl.setDataservice(dataservicemock2); }
	 */
	@Test
	void calsumfromDataService_basic() {
		//fail("Not yet implemented");
		//dataservicemock2 getAllData()  new int[] {1,2,3} //interface implementastion methods
		when(dataservicemock2.getAllData()).thenReturn(new int[] {1,2,3});
		//impl.setDataservice(dataservicemock2);
		assertEquals(6, impl.calsumfromDataService());
	}
	@Test
	void calculate_empty() {
		//fail("Not yet implemented");
		when(dataservicemock2.getAllData()).thenReturn(new int[] {});
		//impl.setDataservice(dataservicemock2);
		assertEquals(0, impl.calsumfromDataService());
	}
	@Test
	void calculate_one() {
		//fail("Not yet implemented");
		when(dataservicemock2.getAllData()).thenReturn(new int[] {1});
		//impl.setDataservice(dataservicemock2);
		assertEquals(1, impl.calsumfromDataService());
	}
}
