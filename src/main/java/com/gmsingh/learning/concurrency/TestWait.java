package com.gmsingh.learning.concurrency;

public class TestWait {

	public synchronized static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t = new Thread();
		t.start();
		System.out.println("X");
		synchronized(t) { 
		t.wait(5000);
		}
		System.out.println("Y");
	}

	
}
