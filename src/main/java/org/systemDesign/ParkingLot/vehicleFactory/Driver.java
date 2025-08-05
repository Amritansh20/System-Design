package org.systemDesign.ParkingLot.vehicleFactory;

public class Driver {
    public static void main(String[] args) {
        String type = "car";
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = factory.createVehicle(type,"123456");
        car.printMessage();
        String lic=car.getLicenceNo();
        System.out.println(lic);
    }
}
