package org.systemDesign.ParkingLot.vehicleFactory;

public class Truck extends Vehicle{
    public Truck(String licenceNo) {
        super(licenceNo);
    }

    @Override
    void printMessage() {
        System.out.println("Truck Created");
    }
}
