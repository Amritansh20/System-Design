package org.systemDesign.ParkingLot.parkingSpotFactory;

public class Driver {
    public static void main(String[] args) {
        String type = "HandiCAPPED";
        ParkingSpotFactory factory = new ParkingSpotFactory();
        ParkingSpot largeParkingSpot = factory.createParkingSpot(1,type);
        largeParkingSpot.printMesaage();
    }
}
