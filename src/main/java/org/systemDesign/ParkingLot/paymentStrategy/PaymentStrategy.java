package org.systemDesign.ParkingLot.paymentStrategy;

import org.systemDesign.ParkingLot.PaymentStatus;

import java.util.Date;

public interface PaymentStrategy {
    boolean initiateTxn();
}
