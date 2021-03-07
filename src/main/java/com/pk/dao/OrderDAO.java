package com.pk.dao;

import com.pk.models.OrdersDaoBeans;

public class OrderDAO {

	String oid; 
	public OrderDAO(String oid) {
		this.oid = oid;
	}

	public OrdersDaoBeans getOrders(String oid) {
		//connect to DB
		//get the response from db
		OrdersDaoBeans odb = new OrdersDaoBeans();
		odb.setDesc("Good");
		odb.setStatus("Deliverd");
		return odb;
	}
}
