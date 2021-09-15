package com.ameen.dp.adapter;

public class Structural_AdapterExampleRupeesToDollar {
    public static void main(String[] args) {
        IndianPaymentApp indianPaymentApp = new IndianPaymentAppImpl();
        System.err.println(indianPaymentApp.pay(35000));
    }
}

interface IndianPaymentApp {
    String pay(int rupees);
}

class IndianPaymentAppImpl implements IndianPaymentApp {
    PaymentAdapter paymentAdapter = new PaymentAdapter();

    @Override
    public String pay(int rupees) {
        return paymentAdapter.pay(rupees);
    }
}

interface AmericanPaymentApp {
    String pay(int dollars);
}

class AmericanPaymentAppImpl implements AmericanPaymentApp {
    @Override
    public String pay(int dollars) {
        return "Paid dollars of " + dollars;
    }
}

class PaymentAdapter {
    AmericanPaymentApp americanPaymentApp = new AmericanPaymentAppImpl();

    String pay(int rupees) {
        int dollars = rupees / 70;
        americanPaymentApp.pay(dollars);
        return "Dollars paid for india rupees " + rupees + " is " + dollars;
    }
}
