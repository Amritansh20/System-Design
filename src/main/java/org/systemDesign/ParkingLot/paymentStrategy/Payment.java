package org.systemDesign.ParkingLot.paymentStrategy;

import lombok.Getter;
import org.systemDesign.ParkingLot.PaymentStatus;

import java.util.Date;

@Getter
public class Payment {
    protected  double amount;
    protected PaymentStatus paymentStatus;
    protected Date timestamp;

    public Payment(double amount){
        this.amount=amount;
        this.paymentStatus=PaymentStatus.PENDING;
        this.timestamp= new Date();
    }
}
