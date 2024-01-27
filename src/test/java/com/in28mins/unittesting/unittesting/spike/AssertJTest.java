package com.in28mins.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
//assertj is better than hamcrest library from usage perspective
public class AssertJTest {
	@Test
	public void learning()
	{
		 List<Integer> number = Arrays.asList(12, 15, 20);
		/*
		 * List<Integer> number = Arrays.asList(12, 15, 20); assertThat(number,
		 * hasSize(3)); assertThat(number, hasItems(12, 15)); assertThat(number,
		 * everyItem(greaterThan(10))); assertThat(number, everyItem(lessThan(10)));
		 */
		//CTR+SHIFT+O after commenting removes imports
		assertThat(number).hasSize(3).contains(12,15);
		//all numbers greater than ten
		assertThat(number).allMatch(x->x>10);//lamda function every element greater than 10
	}
}
