package com.gmsingh.learning.concurrency.threads;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread {
	private BlockingQueue<Runnable> taskQueue = null;
	private volatile boolean isStopped = false;
	
	public PoolThread(BlockingQueue<Runnable> queue) {
		taskQueue = queue;
	}
	
	public void doStop() {
		isStopped = true;
		this.interrupt();
	}
	
	public void run() {
		while(!isStopped) {
			try {
				Runnable task = taskQueue.take();
				//System.out.println("Got a task to run");
				task.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//java.util.logging.Logger
				//e.printStackTrace();
			}
		}
	}
}
