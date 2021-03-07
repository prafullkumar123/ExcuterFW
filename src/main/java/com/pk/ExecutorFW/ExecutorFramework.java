package com.pk.ExecutorFW;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
public class ExecutorFramework {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(3);
		int CVV = new Scanner(System.in).nextInt();
		String CardNo = new Scanner(System.in).next();

		Set<Callable<String>> listOfTasks = new HashSet<Callable<String>>();

		listOfTasks.add(()->{
			if(CVV == 200)
				return "OK";
			return "Not Match";
		});
		listOfTasks.add(()->{
			if(CardNo.equalsIgnoreCase("6100400"))
				return "OK";
			return "Not Match";
		});

		executor.invokeAll(listOfTasks)
		.stream()
		.map((future)->{
			try {
				return future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		})
		.forEach(System.out::println);
		;

	}
}
