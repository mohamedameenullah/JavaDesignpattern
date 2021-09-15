package com.ameen.dp.singleton.threadsafe;

public class MyThread implements Runnable {

	@Override
	public void run() {
		SingletonThreadSafe singletonThreadSafe = SingletonThreadSafe.getInstance();
		System.out.println(Thread.currentThread().getName() + "  " + singletonThreadSafe.hashCode());

	}

}
