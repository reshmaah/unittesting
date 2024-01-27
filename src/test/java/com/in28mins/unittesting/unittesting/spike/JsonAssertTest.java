package com.in28mins.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	private String actualResponse = "{\"qty\":5,\"price\":10,\"name\":\"Ball\",\"id\":1}";
	@Test
	public void jsonAssert() throws JSONException
	{
		String expectedResponse = "{\"qty\":5,        \"price\":10,\"name\":\"Ball\"}";
		String expectedResponse2 = "{\"qty\":5,        \"price\":10,\"name\":\"Ball\",\"id\":1}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		JSONAssert.assertEquals(expectedResponse2, actualResponse, true);
	}
	@Test
	public void jsonAssert_wothoutescape() throws JSONException
	{
		String expectedResponse = "{qty:5,price:10,name:Ball}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
	}
}
