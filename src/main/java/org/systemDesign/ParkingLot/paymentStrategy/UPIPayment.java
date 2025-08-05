package org.systemDesign.ParkingLot.paymentStrategy;

import org.systemDesign.ParkingLot.PaymentStatus;

public class UPIPayment extends Payment implements PaymentStrategy{
    private String upiId;

    public UPIPayment(double amount, String upiId){
        super(amount);
        this.upiId=upiId;
    }

    @Override
    public boolean initiateTxn() {
        super.paymentStatus = PaymentStatus.COMPLETED;
        System.out.println("UPI payment of $ "+amount+" completed");
        return  true;
    }
}
