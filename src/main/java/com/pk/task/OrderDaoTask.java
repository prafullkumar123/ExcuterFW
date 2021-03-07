package com.pk.task;

import java.util.concurrent.Callable;

import com.pk.dao.OrderDAO;
import com.pk.models.OrdersDaoBeans;
import com.pk.models.TaskResult;

public class OrderDaoTask implements Callable<TaskResult>{

	private String oid;
	public OrderDaoTask(String oid) {
		// TODO Auto-generated constructor stub
		this.oid=oid;
	}
	
	public TaskResult call() {
		System.out.println("Start OrderDaoTask ******");
		OrderDAO dao = new OrderDAO(oid);
		OrdersDaoBeans resp= dao.getOrders(oid);
		TaskResult taskResult = new TaskResult();
		taskResult.setTaskName("task2");
		taskResult.setResult(resp);
		System.out.println("End OrderDaoTask *******");
		return taskResult;
	}
}
