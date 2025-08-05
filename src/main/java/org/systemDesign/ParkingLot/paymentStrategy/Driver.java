package org.systemDesign.ParkingLot.paymentStrategy;

public class Driver {
    public static void main(String[] args) {
        PaymentStrategy strategy = new UPIPayment(300.77, "77623975@ybl");
        PaymentContext paymentContext = new PaymentContext(strategy);
        paymentContext.completeTxn();
    }
}
