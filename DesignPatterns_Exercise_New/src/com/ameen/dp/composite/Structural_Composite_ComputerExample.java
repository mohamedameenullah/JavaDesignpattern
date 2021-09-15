package com.ameen.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class Structural_Composite_ComputerExample {
    public static void main(String[] args) {
        // For Cabinet
        Component hardDrive = new Leaf("HardDrive", 4000);

        // Peripheral devices
        Component mouse = new Leaf("Mouse", 250);
        Component monitor = new Leaf("Monitor", 2500);
        Component keyboard = new Leaf("Keyboard", 500);

        // For Motherboard
        Component ram = new Leaf("RAM", 2500);
        Component cpu = new Leaf("CPU", 3000);


        //Construct MotherBoard
        Composite motherBoard = new Composite("MotherBoard");
        motherBoard.addComponent(cpu);
        motherBoard.addComponent(ram);
        // Construct Cabinet
        Composite cabinet = new Composite("Cabinet");
        cabinet.addComponent(motherBoard);
        cabinet.addComponent(hardDrive);
        // Construct Peripherals
        Composite peripherals = new Composite("Peripherals" );
        peripherals.addComponent(mouse);
        peripherals.addComponent(keyboard);
        peripherals.addComponent(monitor);
        // Construct Computer
        Composite computer = new Composite("Computer");
        computer.addComponent(peripherals);
        computer.addComponent(cabinet);

        computer.showPrice();


    }
}

interface Component {
    void showPrice();
}

class Leaf implements Component {
    String name;
    int price;

    public Leaf(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println("Name : " + name + " and Price is : "+ price);
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Composite implements Component {
    String name;
    List<Component> componentList = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(Component c){
        componentList.add(c);
    }

    @Override
    public void showPrice() {
        System.out.println(this.toString());
        componentList.stream().forEach(Component::showPrice);
    }

    @Override
    public String toString() {
        return "Composite{" +
                "name='" + name + '\'' +
                ", componentList=" + componentList +
                '}';
    }
}
