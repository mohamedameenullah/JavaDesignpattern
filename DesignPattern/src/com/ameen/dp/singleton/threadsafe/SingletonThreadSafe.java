package com.ameen.dp.singleton.threadsafe;

public class SingletonThreadSafe {
	private static SingletonThreadSafe INSTANCE;

	private SingletonThreadSafe() {
	}

	// static synchronized block will always have a lock on class level
	public static synchronized SingletonThreadSafe getInstance() {
		if (INSTANCE == null) {
			try {
				Thread.sleep(3000);
				INSTANCE = new SingletonThreadSafe();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return INSTANCE;
	}
}
