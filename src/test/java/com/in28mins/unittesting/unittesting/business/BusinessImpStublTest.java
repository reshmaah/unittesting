package com.in28mins.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.in28mins.unittesting.unittesting.BusinessImpl;
import com.in28mins.unittesting.unittesting.someDataService;
class someDataServicestub implements someDataService 
{

	@Override
	public int[] getAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}
	
}
class BusinessImpStublTest {

	@Test
	void calsumfromDataService_basic() {
		//fail("Not yet implemented");
		BusinessImpl impl = new BusinessImpl();
		impl.setDataservice(new someDataServicestub());
		int actualresult = impl.calsumfromDataService();
		int ex = 6;
		assertEquals(ex, actualresult);
	}
	@Test
	void calculate_empty() {
		//fail("Not yet implemented");
		BusinessImpl impl = new BusinessImpl();
		int actualresult = impl.calsum(new int[] {});
		int ex = 0;
		assertEquals(ex, actualresult);
	}
	@Test
	void calculate_one() {
		//fail("Not yet implemented");
		BusinessImpl impl = new BusinessImpl();
		int actualresult = impl.calsum(new int[] {1});
		int ex = 1;
		assertEquals(ex, actualresult);
	}
}
