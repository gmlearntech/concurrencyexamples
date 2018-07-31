package com.gmsingh.learning.concurrency.threads;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ThreadPoolTest {

	private static ThreadPool threadPool;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		threadPool = new ThreadPool(10, 10);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//System.out.println("Stopping the thread pool");
		//threadPool.stop();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecuteTask() throws InterruptedException {
		int n = 20;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch endSignal = new CountDownLatch(n);
		AtomicInteger threadCount = new AtomicInteger(0);
		for(int i = 1; i <= n; i++) {
			threadPool.executeTask(new TestTask(i, startSignal, endSignal, threadCount));
		}
		startSignal.countDown();
		endSignal.await();//fail("Not yet implemented");
		System.out.println("threadCount = " + threadCount);
		assertEquals(n, threadCount.get());
	}

	class TestTask implements Runnable {
		private int id;
		private final CountDownLatch startSignal,  endSignal;
		AtomicInteger threadCount;
		
		public TestTask(int id, CountDownLatch startSignal, CountDownLatch endSignal, AtomicInteger threadCount) {
			this.id = id;
			this.startSignal = startSignal;
			this.endSignal = endSignal;
			this.threadCount = threadCount;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				startSignal.await();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread with id = " + id);
			threadCount.incrementAndGet();
			endSignal.countDown();
		}
	}
	
	@Test
	public void testStop() {
		fail("Not yet implemented");
	}

}
