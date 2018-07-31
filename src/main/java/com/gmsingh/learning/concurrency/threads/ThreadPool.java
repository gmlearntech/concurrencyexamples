package com.gmsingh.learning.concurrency.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	private BlockingQueue<Runnable> taskQueue;
	private List<PoolThread> threads;
	private boolean isStopped = false;
	
	public ThreadPool(int maxThreads, int maxTasks) {
		threads = new ArrayList<>(maxThreads);
		taskQueue = new ArrayBlockingQueue<>(maxTasks);
		for(int i=0; i < maxThreads; i++) {
			threads.add(new PoolThread(taskQueue));
		}
		// start all threads
		System.out.println("Starting all threads in the pool");
		//threads.forEach(t -> t.start());
		for(PoolThread t:threads) {
			t.start();
		}
	}
	
	public synchronized void executeTask(Runnable task) {
		//System.out.println("Got a task to execute");
		if(isStopped) {
			throw new IllegalStateException("Thread pool is stopped");
		}
		try {
			//System.out.println("Trying to add a new task to the queue");
			taskQueue.put(task);
			//System.out.println("added a new task to the queue");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void stop() {
		isStopped = true;
		threads.forEach(t -> t.doStop());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
