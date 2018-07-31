package com.gmsingh.learning.concurrency;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterTest {

	public static void main(String[] args) {
		final Counter counter = new Counter();
		
		ArrayList<Thread> threads = new ArrayList<>();
		// create 100 threads
		for(int i = 0; i < 100; i++) {
			threads.add(new Thread(new CounterTask(counter)));
		}
		// start all threads
		threads.forEach(t -> t.start());
		// wait for threads to finish
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println(counter.getCount());
	}

}

class CounterTask implements Runnable {

	private Counter counter;
	
	CounterTask(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		counter.incrementCount();
	}
	
}

class Counter {
	private AtomicInteger count = new AtomicInteger(0);
	
	void incrementCount() {
		count.incrementAndGet();
	}
	
	int getCount() {
		return count.get();
	}
}