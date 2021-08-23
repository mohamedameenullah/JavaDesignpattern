package com.ameen.dp.proxy;

public class VeryExpensiveProcessImpl implements VeryExpensiveProcess {

	public VeryExpensiveProcessImpl() {
		heavyInitialConfigSetup();
	}

	@Override
	public void process() {
		System.out.println("Im doing my process here. The expensive configuration is already done.");
	}

	private void heavyInitialConfigSetup() {
		System.out.println("Im doing heavy initial configuration setup here. The should be executed only once.");
	}

}
