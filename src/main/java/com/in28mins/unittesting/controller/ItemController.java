package com.in28mins.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.unittesting.model.Item;
import com.in28mins.unittesting.service.ItemFromBusinessService;

@RestController

public class ItemController {
	
	private final GreetingService service;
	@Autowired
	private ItemFromBusinessService businessItem;
	
	@GetMapping("/dummy-item")
	public Item hello()
	{
		return new Item(1,"Ball", 10, 5 );
	}

	@GetMapping("/itemfromBusinessService")
	public Item itemfromBusinessService()
	{
		return businessItem.item();
	}
	public ItemController(GreetingService service) {
		this.service = service;
	}
	@GetMapping("/listofitems")
	public List<Item> getAllItems()
	{
		return businessItem.retriveallItems();
	}

	/*
	 * @GetMapping("/greeting") public @ResponseBody String greeting() { return
	 * service.greet(); }
	 */
}
