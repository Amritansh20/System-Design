package org.systemDesign.ParkingLot.paymentStrategy;

public class PaymentContext {
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy strategy){
        this.paymentStrategy=strategy;
    }

    public void completeTxn(){
        if(paymentStrategy==null){
            System.out.println("Please select a payment method.");
            return;
        }
        paymentStrategy.initiateTxn();
    }
}
