package com.gmsingh.learning.concurrency.threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	protected BlockingQueue<?> queue = null;

    public Consumer(BlockingQueue<?> queue) {
        this.queue = queue;
    }
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 try {
	            System.out.println(queue.take());
	            System.out.println(queue.take());
	            System.out.println(queue.take());
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}

}
