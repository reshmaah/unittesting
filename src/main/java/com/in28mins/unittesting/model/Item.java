package com.in28mins.unittesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Item {
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int qty;
	private int price;
	private String name;
	@Id
	private int id;
	@Transient
	private int value;

	public Item(int id, String name, int price, int qty) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public Item(int qty, int price, String name, int id, int value) {
		super();
		this.qty = qty;
		this.price = price;
		this.name = name;
		this.id = id;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		/*
		 * return "Item [qty=" + qty + ", price=" + price + ", name=" + name + ", id=" +
		 * id + ", getQty()=" + getQty() + ", getPrice()=" + getPrice() + ", getName()="
		 * + getName() + ", getId()=" + getId() + ", getClass()=" + getClass() +
		 * ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		 
		 */
		return String.format("Item[%d, %s, %d, %d", id, name, price, qty);
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
