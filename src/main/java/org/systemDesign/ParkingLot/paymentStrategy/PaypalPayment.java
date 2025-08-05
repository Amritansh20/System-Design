package org.systemDesign.ParkingLot.paymentStrategy;

import org.systemDesign.ParkingLot.PaymentStatus;

public class PaypalPayment extends Payment implements PaymentStrategy {
    private String email;

    public PaypalPayment(double amount, String email){
        super(amount);
        this.email=email;
    }

    @Override
    public boolean initiateTxn() {
        super.paymentStatus = PaymentStatus.COMPLETED;
        System.out.println("Paypal payment of $ "+amount+" completed");
        return  true;
    }
}
