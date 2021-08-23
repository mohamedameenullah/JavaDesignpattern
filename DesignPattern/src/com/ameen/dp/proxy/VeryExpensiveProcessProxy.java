package com.ameen.dp.proxy;

public class VeryExpensiveProcessProxy implements VeryExpensiveProcess {

	private static VeryExpensiveProcess veryExpensiveProcess;
	
	@Override
	public void process() {
		if(veryExpensiveProcess == null) {
			veryExpensiveProcess = new VeryExpensiveProcessImpl();
		}
		veryExpensiveProcess.process();
	}

}
