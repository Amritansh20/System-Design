package org.systemDesign.ParkingLot.paymentStrategy;

import org.systemDesign.ParkingLot.PaymentStatus;

public class CreditCardPayment extends Payment implements PaymentStrategy{
    private String cardNumber;
    private String cvv;


    public CreditCardPayment(double amount,String cardNumber, String cvv){
        super(amount);
        this.cardNumber=cardNumber;
        this.cvv=cvv;
    }
    @Override
    public boolean initiateTxn() {
        super.paymentStatus = PaymentStatus.COMPLETED;
        System.out.println("Credit card payment of $ "+amount+" completed");
        return true;
    }
}
