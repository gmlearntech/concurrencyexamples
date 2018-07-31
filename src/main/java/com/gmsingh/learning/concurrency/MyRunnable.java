package com.gmsingh.learning.concurrency;

public class MyRunnable implements Runnable {

	public void run() {
		System.out.println("Executing thread : " + Thread.currentThread().getName());

	}

	public static void main(String[] args) {
		// another way of creating a thread - create a runnable and pass to Thread
		Thread mt = new Thread(new MyRunnable(), "MyRunnableThread");
		mt.start();
		
		// Java 8 way of creating a thread from runnable
		Thread mySecondThread = new Thread(()-> { 
			System.out.println("Executing thread in java8 way: " + Thread.currentThread().getName());
			}, "MyJava8RunnableThread");
		mySecondThread.start();
	}
}
