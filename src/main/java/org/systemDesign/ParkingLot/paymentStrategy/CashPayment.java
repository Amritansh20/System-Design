package org.systemDesign.ParkingLot.paymentStrategy;

public class CashPayment extends Payment implements PaymentStrategy{

    public CashPayment(double amount){
        super(amount);
    }

    @Override
    public boolean initiateTxn() {
        System.out.println("Cash payment of $ "+amount+" completed");
        return  true;
    }
}
