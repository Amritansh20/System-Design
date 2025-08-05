package org.systemDesign.ParkingLot.vehicleFactory;

public class Motorcycle extends Vehicle{
    public Motorcycle(String licenceNo){
        super(licenceNo);
    }

    @Override
    void printMessage() {
        System.out.println("Motorcycle Created");
    }
}
