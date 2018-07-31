package com.gmsingh.learning.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 20; i++) {
			service.submit(new Task(i+1));
		}
		service.shutdown();
	}

}

final class Task implements Runnable {
	private int id;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Executing task with id : " + id + " in thread " + Thread.currentThread().getName());
	}
	
	public Task(int id) {
		this.id = id;
	}
}