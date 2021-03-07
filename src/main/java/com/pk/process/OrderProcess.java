package com.pk.process;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.pk.models.OrderdetailsResponse;
import com.pk.models.OrdersDaoBeans;
import com.pk.models.OrdersInfoBean;
import com.pk.models.TaskResult;
import com.pk.task.OrderDaoTask;
import com.pk.task.OrdersInfoTask;

public class OrderProcess {
	
	public OrderdetailsResponse getOrder(String oid) throws InterruptedException, ExecutionException {
		
		OrderdetailsResponse response =new OrderdetailsResponse();
		ExecutorService  executorService = Executors.newFixedThreadPool(2);
		
		Set tasks = new HashSet();
		tasks.add(new OrdersInfoTask(oid));
		tasks.add(new OrderDaoTask(oid));
		System.out.println("Start Parellel Call");
		
		List<Future<TaskResult>> listOfFuture = executorService.invokeAll(tasks);
		for(Future future : listOfFuture) {
			TaskResult taskResult = (TaskResult) future.get();
			String taskName = taskResult.getTaskName();
			if ("task1".equals(taskName)) {
				OrdersInfoBean resp = (OrdersInfoBean) taskResult.getResult();
				response.setName(resp.getName());
				response.setPrice(resp.getPrice());
				response.setDate(resp.getDate());
				System.out.println("taskName :: "+taskName);
			}
			else {
				OrdersDaoBeans resp = (OrdersDaoBeans) taskResult.getResult();
				response.setDesc(resp.getDesc());
				response.setStatus(resp.getStatus());
				System.out.println("taskName :: "+taskName);
			}
			
		}
		System.out.println("Exit Parellel Call");
		return response;
	}

}
