package com.ameen.dp.singleton.threadsafe;

public class SingletonThreadSafeWithLessCost {
	private static SingletonThreadSafeWithLessCost INSTANCE;

	private SingletonThreadSafeWithLessCost() {
	}

	// static synchronized block will always have a lock on class level
	public static SingletonThreadSafeWithLessCost getInstance() {

		if (INSTANCE == null) {
			synchronized (SingletonThreadSafeWithLessCost.class) {
				if (INSTANCE == null) {
					try {
						Thread.sleep(3000);
						INSTANCE = new SingletonThreadSafeWithLessCost();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}

		return INSTANCE;
	}
}
