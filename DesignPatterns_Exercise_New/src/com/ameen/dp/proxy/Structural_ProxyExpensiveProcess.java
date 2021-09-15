/**
 *
 */
package com.ameen.dp.proxy;

/**
 * @author Ameenullah
 *
 */
public class Structural_ProxyExpensiveProcess {

    public static void main(String[] args) {
        VeryExpensiveProcess expensiveProcessProxy = new VeryExpensiveProcessProxy();
        expensiveProcessProxy.process();
        expensiveProcessProxy.process();
    }
}

interface VeryExpensiveProcess {
    public void process();
}

class VeryExpensiveProcessImpl implements VeryExpensiveProcess {

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

class VeryExpensiveProcessProxy implements VeryExpensiveProcess {

    private static VeryExpensiveProcess veryExpensiveProcess;

    @Override
    public void process() {
        if (veryExpensiveProcess == null) {
            veryExpensiveProcess = new VeryExpensiveProcessImpl();
        }
        veryExpensiveProcess.process();
    }

}

