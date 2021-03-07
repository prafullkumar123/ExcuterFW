package com.pk.resource;

import java.util.concurrent.ExecutionException;

import com.pk.models.OrderdetailsResponse;
import com.pk.process.OrderProcess;

public class OrderResource {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		OrderProcess process = new OrderProcess();
		OrderdetailsResponse resp = process.getOrder("1324354");
		System.out.println("Response is :: "+resp);
	}
}
