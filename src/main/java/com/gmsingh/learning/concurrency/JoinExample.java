package com.gmsingh.learning.concurrency;

import java.util.Random;

public class JoinExample implements Runnable {

	private Random rand = new Random(System.currentTimeMillis());
	@Override
	public void run() {
		// do some dummy CPU consuming task
		for(int i = 0; i < 1000000; i++) {
			rand.nextInt();
		}
		System.out.println("[" + Thread.currentThread().getName() + "] finished..");
	}

	public static void main(String[] args) throws InterruptedException {
		// start 5 different threads
		Thread[] threads = new Thread[5];
		//ThreadPoolExecutor tpe = new ThreadPoolExecutor();
		for(int i = 0; i < 5; i++) {
			threads[i] = new Thread(new JoinExample(), "Thread " + i);
			threads[i].start();
		}
		
		// wait for threads to finish
		for(int i = 0; i < 5; i++) {
			threads[i].join();
		}
		System.out.println("["+Thread.currentThread().getName()+"] All threads finished");
	}

}
