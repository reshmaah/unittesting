package com.in28mins.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28mins.unittesting.data.ItemRepository;
import com.in28mins.unittesting.model.Item;


@Component
public class ItemFromBusinessService {
	@Autowired
	private ItemRepository itemrepository;
	public Item item()
	{
		return new Item(1,"BAT", 10,10);
	}
	public List<Item> retriveallItems()
	{
		List<Item> items = itemrepository.findAll();
		for(Item item:items )
		{
			item.setValue(item.getPrice()*item.getQty());
		}
		return items;
	}
}
