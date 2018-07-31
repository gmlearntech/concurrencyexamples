package com.gmsingh.learning.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer>[] futures = new Future[10];
		for(int i = 0; i < futures.length; i++) {
			futures[i] = service.submit(new CallableTask());
		}
		
		for(int i = 0; i < futures.length; i++) {
			//if(futures[i].isDone()) 
			{
				int value = futures[i].get();
				System.out.println(value);
			}
		}
		
		service.shutdown();
	}

}

final class CallableTask implements Callable<Integer> {

	private  static Random rand = new Random(System.currentTimeMillis());
	@Override
	public Integer call() throws Exception {
		Thread.sleep(1000);
		return rand.nextInt(100);
	}

}

