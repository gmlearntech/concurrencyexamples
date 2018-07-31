package com.gmsingh.learning.concurrency;

public class InterruptExample implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted while sleeping: " + Thread.currentThread().getName());
		}
		// do nothing while thread is not interrupted
		while(!Thread.interrupted()) {
			// do nothing
		}
		System.out.println("Thread interrupted again : " + Thread.currentThread().getName());
	}

	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread(new InterruptExample(), "MyThread");
		myThread.start();
		
		// main thread sleeps for a while
		System.out.println(Thread.currentThread().getName() + " thread sleeping for 5 seconds..");
		Thread.sleep(5000);
		// myThread interrupted while sleeping
		System.out.println(Thread.currentThread().getName() + " interrupting " + myThread.getName());
		myThread.interrupt();
		// main thread again sleeps for a while
		System.out.println(Thread.currentThread().getName() + " thread sleeping for 5 seconds..");
		Thread.sleep(5000);
		// myThread interrupted again..
		System.out.println(Thread.currentThread().getName() + " interrupting " + myThread.getName() + " again.." );
		myThread.interrupt();
		/*
		What is interesting in this output, are the lines 3 and 4. If we go through the code we might have expected that the string
		"Interrupted by exception!" is printed out before the main thread starts sleeping again with "Sleeping in main thread for 5s. . . ".
		But as you can see from the output, the scheduler has executed the main thread before it started myThread again. Hence myThread
		prints out the reception of the exception after the main thread has started sleeping.
		*/
	}

}
