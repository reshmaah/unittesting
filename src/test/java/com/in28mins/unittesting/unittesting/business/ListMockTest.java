package com.in28mins.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ListMockTest {
	List mock = mock(List.class);
	@Test
	void test() {
		//fail("Not yet implemented");
	
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
		
	}
	void test_second() {
		//fail("Not yet implemented");
	
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());//calling second time returns second invocation of then return
		assertEquals(10, mock.size());//calling second time returns second invocation of then return
	}
	void returnWithParameter() {
		//fail("Not yet implemented");
		
		when(mock.get(anyInt())).thenReturn(5);
		assertEquals(5, mock.size());
		
	}
	@Test
	void returnWithParameter1() {
		//fail("Not yet implemented");
		//Arguement Matcher anyInt();
		when(mock.get(anyInt())).thenReturn("Reshma");
		assertEquals("Reshma", mock.get(0));
		
	}
	@Test
	public void verificationBasics()
	{
		//System unser test
		String value = (String) mock.get(0);
		String value2 = (String) mock.get(1);
		
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(0);
		verify(mock,atMost(3)).get(0);
	}
	@Test
	public void ArguementCapturing()
	{
		//System unser test
		mock.add("SomeString"); // similar to data stored in DB
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("SomeString", captor.getValue());
	}
	@Test
	public void MultipleArguementCapturing()
	{
		//System unser test
		mock.add("SomeString1"); // similar to data stored in DB
		mock.add("SomeString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture()); //this place we capture stored arguement
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
		
	}
	@Test
	public void Mocking()
	{
		ArrayList arraylistMock = mock(ArrayList.class);
		System.out.println(arraylistMock.get(0));
		System.out.println(arraylistMock.size());
		System.out.println(arraylistMock.add("String1"));
		System.out.println(arraylistMock.add("String2"));
		System.out.println(arraylistMock.size());//returns 0 as tthis is just a mock class
		when(arraylistMock.size()).thenReturn(5);
		System.out.println(arraylistMock.size()); //return 5
		
	}
	@Test
	public void spying()
	{
		ArrayList arrayListSpy = spy(ArrayList.class); //spy uses actual behaviour of 
		arrayListSpy.add("test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		System.out.println(arrayListSpy.add("String1"));
		System.out.println(arrayListSpy.add("String2"));
		System.out.println(arrayListSpy.size());//returns 0 as tthis is just a mock class
		when(arrayListSpy.size()).thenReturn(5); //it 
		System.out.println(arrayListSpy.size()); //return 5
		//check why not working
		//verify(arrayListSpy).add("test3"); //if we do not have access to specific class to get data from it but want to check what is going on in that class, then we can use spy and we can do verifications on it
		//mocking is instead of real world action
		//spying is in addition to real world action.
	}
}
