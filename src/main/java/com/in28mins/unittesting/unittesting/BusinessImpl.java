package com.in28mins.unittesting.unittesting;

import java.util.Arrays;
import java.util.OptionalInt;

public class BusinessImpl {
	someDataService dataservice;
	
  public someDataService getDataservice() {
		return dataservice;
	}
	public void setDataservice(someDataService dataservice) {
		this.dataservice = dataservice;
	}
public int calsum(int[] data)
  {
	  int sum = 0;
	  
	  for (int value:data)
	  {
		  sum+=value;
	  }
	  return sum;
  }
public int calsumStream(int[] data)
{
	OptionalInt sum = Arrays.stream(data).reduce(Integer::sum);
	return sum.orElse(0);
	// or inline return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	//functional programming in Java - in resurces
}
  public int calsumfromDataService()
  {
	  int sum = 0;
	  int[] data = dataservice.getAllData();
	  for (int value:data)
	  {
		  sum+=value;
	  }
	  return sum;
  }
}
