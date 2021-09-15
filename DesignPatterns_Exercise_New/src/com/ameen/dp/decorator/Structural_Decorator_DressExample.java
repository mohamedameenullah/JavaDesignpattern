package com.ameen.dp.decorator;

public class Structural_Decorator_DressExample {
    public static void main(String[] args) {
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }
}

interface Dress {
    public void assemble();
}

class DressDecorator implements Dress {
    Dress dress;

    DressDecorator(Dress dress){
        this.dress = dress;
    }

    @Override
    public void assemble() {
        dress.assemble();
    }
}

class FancyDress extends  DressDecorator {

    FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Doing Fancy dress assembling...");
    }
}

class CasualDress extends  DressDecorator {

    CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Doing Casual dress assembling...");
    }
}

class SportyDress extends  DressDecorator {

    SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Doing Sporty dress assembling...");
    }
}

class BasicDress implements Dress {

    @Override
    public void assemble() {
        System.out.println("Basic Dress assembling...");
    }
}

