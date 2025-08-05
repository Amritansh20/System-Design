package org.systemDesign.ParkingLot.vehicleFactory;

public class Vans extends Vehicle{
    public Vans(String licenceNo) {
        super(licenceNo);
    }

    @Override
    void printMessage() {
        System.out.println("Van Created");
    }
}
