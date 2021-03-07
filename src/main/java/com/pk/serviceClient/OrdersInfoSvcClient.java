package com.pk.serviceClient;

import com.pk.models.OrdersInfoBean;

public class OrdersInfoSvcClient {
	
	public OrdersInfoBean getOrders(String oid) {
		
		//calls service and get the response 
		//orders info bean response 
		OrdersInfoBean oib = new OrdersInfoBean();
		oib.setName("mobile");
		oib.setDate("25/09/2020");
		oib.setPrice("30000");
		return oib;
	}
}
