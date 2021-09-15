package com.ameen.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class Structural_Composite_EmployeeExample {
    public static void main(String[] args) {
        EmployeeComponent dev1 = new Developer(1, "Mohamed", 30, "Tenkasi");
        EmployeeComponent dev2 = new Developer(2, "Guhan", 29, "Chennai");
        EmployeeComponent dev3 = new Developer(3, "Mani", 31, "Chennai");
        Manager m1 = new Manager(6, "Ravi", 40, "Madurai");
        m1.addEmployee(dev1);
        m1.addEmployee(dev2);
        m1.addEmployee(dev3);
        Manager m2 = new Manager(7, "Bharathi", 40, "Chennai");
        EmployeeComponent dev4 = new Developer(4, "Amar", 30, "AP");
        EmployeeComponent dev5 = new Developer(5, "Ameen", 30, "Tenkasi");
        m2.addEmployee(dev4);
        m2.addEmployee(dev5);
        m2.addEmployee(m1);
        Manager m3 = new Manager(8, "Sudhakar", 45, "AP");
        m3.addEmployee(m2);
        EmployeeComponent dev6 = new Developer(9, "Ayyappan", 35, "Arakonam");
        m3.addEmployee(dev6);
        m3.showDetails();
    }
}

interface EmployeeComponent {
    void showDetails();
}

class Developer implements EmployeeComponent {
    int id;
    String name;
    int age;
    String address;

    public Developer(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee Details... Id " + this.id + " \n Name : " + this.name + " \n Age: " + this.age + " \n Address: " + this.address);
    }
}

class Manager implements EmployeeComponent {
    int id;
    String name;
    int age;
    String address;
    List<EmployeeComponent> developerLeafList = new ArrayList<>();

    public Manager(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void addEmployee(EmployeeComponent employeeComponent) {
        developerLeafList.add(employeeComponent);
    }

    @Override
    public void showDetails() {
        System.out.println(this.toString());
        developerLeafList.stream().forEach(EmployeeComponent::showDetails);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", developerLeafList=" + developerLeafList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<EmployeeComponent> getDeveloperLeafList() {
        return developerLeafList;
    }

    public void setDeveloperLeafList(List<EmployeeComponent> developerLeafList) {
        this.developerLeafList = developerLeafList;
    }
}


