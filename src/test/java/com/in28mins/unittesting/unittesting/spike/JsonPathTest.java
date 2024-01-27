package com.in28mins.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning()
	{
		String responseService = "["
				+ "{\"id\":1000, \"name\":\"pencil\", \"qty\":10}"
				+ "{\"id\":1001, \"name\":\"pen\", \"qty\":10}"
				+ "{\"id\":1002, \"name\":\"paper\", \"qty\":10}"
				+ "]";
		DocumentContext context = JsonPath.parse(responseService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(1000,1001,1002);
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read(".[?(@.name=='pen')]").toString());
		System.out.println(ids.toString());
	}
	//Unit testing patterns
	//http://xunitpatterns.com
	
}
