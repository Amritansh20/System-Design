package org.systemDesign.ParkingLot.vehicleFactory;

public class Car extends Vehicle{
    public Car(String licenceNo){
        super(licenceNo);
    }

    @Override
    void printMessage() {
        System.out.println("Car created");
    }

}
