package com.gmsingh.learning.concurrency;

/*
 * one way of creating a thread - extend the Thread class
 */
public class MyThread extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread();
		mt.setName("My Thread");
		mt.start();
	}

	@Override
	public void run() {
		System.out.println("Executing thread : " + Thread.currentThread().getName());
	}

}
