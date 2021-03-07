package com.pk.task;

import java.util.concurrent.Callable;

import com.pk.models.OrdersInfoBean;
import com.pk.models.TaskResult;
import com.pk.serviceClient.OrdersInfoSvcClient;

public class OrdersInfoTask implements Callable<TaskResult>{ 

	private String oid;
	public OrdersInfoTask(String oid) {

		this.oid = oid;
	}
	@Override
	public TaskResult call() throws Exception {
		System.out.println("Start OrdersInfoTask ******");
		OrdersInfoSvcClient orderinfosvnclient = new OrdersInfoSvcClient();
		OrdersInfoBean resp = orderinfosvnclient.getOrders(oid);
		TaskResult taskResult = new TaskResult();
		taskResult.setResult(resp);
		taskResult.setTaskName("task1");
		System.out.println("End OrdersInfoTask ******");
		return taskResult;
	}

	
}
