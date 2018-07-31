package com.gmsingh.learning.concurrency.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread tp = new Thread(producer);//.start();
        Thread tc = new Thread(consumer);//.start();
        tp.start();
        tc.start();
        try {
			tp.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			tc.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Thread.sleep(4000);
	}

}
