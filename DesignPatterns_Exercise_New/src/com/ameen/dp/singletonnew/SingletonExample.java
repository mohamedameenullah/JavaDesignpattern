package com.ameen.dp.singletonnew;

/**
 * Singleton Eager We cant handle exceptions here
 * 
 * @author Ameenullah
 *
 */
class SingletonEager {
	private final static SingletonEager SINGLETON_EAGER = new SingletonEager();

	private SingletonEager() {
	}

	public static SingletonEager getInstance() {
		return SINGLETON_EAGER;
	}

}

/**
 * Singleton Eager with static --> to overcome eager init to handle exception We
 * can handle exceptions here
 * 
 * @author Ameenullah
 *
 */
class SingletonEagerStatic {
	private static SingletonEagerStatic SINGLETON_EAGER_STATIC = null;
	
	static {
		try {
			if (SINGLETON_EAGER_STATIC == null) {
				SINGLETON_EAGER_STATIC = new SingletonEagerStatic();
			}
		} catch (Exception e) {

		}
	}

	private SingletonEagerStatic() {
	}

	public static SingletonEagerStatic getInstance() {
		return SINGLETON_EAGER_STATIC;
	}

}

/**
 * Singleton Lazy
 * 
 * @author Ameenullah
 *
 */
class SingletonLazy {
	private static SingletonLazy SINGLETON_LAZY = null;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {
		if (SINGLETON_LAZY == null) {
			return new SingletonLazy();
		}
		return SINGLETON_LAZY;
	}
}

/**
 * Singleton ThreadSafe
 * 
 * @author Ameenullah
 *
 */
class SingletonThreadSafe {
	private static SingletonThreadSafe SINGLETON_THREADSAFE = null;

	private SingletonThreadSafe() {

	}

	public synchronized static SingletonThreadSafe getInstance() {
		if (SINGLETON_THREADSAFE == null) {
			return new SingletonThreadSafe();
		}
		return SINGLETON_THREADSAFE;
	}
}

/**
 * Singleton ThreadSafe Lowcost
 * 
 * @author Ameenullah
 *
 */
class SingletonThreadSafeLowCost {
	private static SingletonThreadSafeLowCost SINGLETON_THREADSAFE_LOWCOST = null;

	private SingletonThreadSafeLowCost() {

	}

	public static SingletonThreadSafeLowCost getInstance() {
		if (SINGLETON_THREADSAFE_LOWCOST == null) {
			synchronized (SingletonThreadSafeLowCost.class) {
				if (SINGLETON_THREADSAFE_LOWCOST == null) {
					return new SingletonThreadSafeLowCost();
				}
			}
		}

		return SINGLETON_THREADSAFE_LOWCOST;
	}
}

class SingletonWithEnum{
	
}

public class SingletonExample {

	public static void main(String[] args) {

	}
}
