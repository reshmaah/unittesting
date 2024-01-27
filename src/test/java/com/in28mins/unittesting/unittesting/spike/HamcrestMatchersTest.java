package com.in28mins.unittesting.unittesting.spike;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

//Other string related imports which we can use assertThat 
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.containsString;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {
	@Test
	public void learning()
	{
		List<Integer> number = Arrays.asList(12, 15, 20);
		assertThat(number, hasSize(3));
		assertThat(number, hasItems(12, 15));
		assertThat(number, everyItem(greaterThan(10)));
		assertThat(number, everyItem(lessThan(10)));
	}
}
