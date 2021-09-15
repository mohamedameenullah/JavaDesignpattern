package com.ameen.dp.singleton.threadsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonThreadSafeTest {
	public static void main(String[] args) {
		ExecutorService service = null;
		MyThread thread = new MyThread();
		try {
			service = Executors.newFixedThreadPool(5);
			service.execute(thread);
			service.execute(thread);
			service.execute(thread);
			service.execute(thread);
			service.execute(thread);
		} catch (Exception e) {

		} finally { // we should always shutdown the executor service.
			if (service != null) {
				service.shutdown();
			}
		}
	}
}
