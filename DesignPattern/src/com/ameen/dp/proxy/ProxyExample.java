/**
 * 
 */
package com.ameen.dp.proxy;

/**
 * @author Ameenullah
 *
 */
public class ProxyExample {

	public static void main(String[] args) {
		VeryExpensiveProcess expensiveProcessProxy = new VeryExpensiveProcessProxy();
		expensiveProcessProxy.process();
		expensiveProcessProxy.process();
	}

}
