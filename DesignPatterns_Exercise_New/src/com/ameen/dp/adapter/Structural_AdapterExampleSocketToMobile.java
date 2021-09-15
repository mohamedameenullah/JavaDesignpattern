package com.ameen.dp.adapter;

public class Structural_AdapterExampleSocketToMobile {
    public static void main(String[] args) {
        SocketWith120Volt socketWith120Volt = new SocketWith120Volt();
        SocketAdapter socketAdapter = new SocketObjectAdapterImpl();
        Volt volt = socketAdapter.get12Volt();
        System.err.println(volt);
    }


}

class Volt {
    private int volts;
    public Volt(int volts) {
        this.volts = volts;
    }
    public int getVolts() {
        return volts;
    }
    public void setVolts(int volts) {
        this.volts = volts;
    }
}

class SocketWith120Volt {
    public Volt getVolt() {
        return new Volt(120);
    }
}

interface SocketAdapter {

    public Volt get120Volt();

    public Volt get12Volt();

    public Volt get3Volt();
}

class SocketObjectAdapterImpl implements SocketAdapter{

    //Using Composition for adapter pattern
    private SocketWith120Volt socket = new SocketWith120Volt();

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        // Get volt
        Volt v= socket.getVolt();
        // convert volt
        int volts = v.getVolts() / 10;
        return new Volt(volts);
    }

    @Override
    public Volt get3Volt() {
        // get volt
        Volt v= socket.getVolt();
        // convert volt
        int volts = v.getVolts() / 40;
        return new Volt(volts);
    }
}

