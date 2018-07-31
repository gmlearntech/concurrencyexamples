package com.gmsingh.learning.concurrency;

import java.lang.Thread.State;

public class MainThread {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		String name = currentThread.getName();
		long id = currentThread.getId();
		int priority = currentThread.getPriority();
		State thState = currentThread.getState();
		String groupName = currentThread.getThreadGroup().getName();
		System.out.println("Name = " + name + ", Id = " + id + ", Priority = " + priority + ", state = " + thState
				+ ", group = " + groupName);
	}

}
