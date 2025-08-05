package org.systemDesign.ParkingLot;

import org.systemDesign.ParkingLot.parkingSpotFactory.CompactParkingSpot;
import org.systemDesign.ParkingLot.parkingSpotFactory.HandicappedParkingSpot;
import org.systemDesign.ParkingLot.parkingSpotFactory.LargeParkingSpot;
import org.systemDesign.ParkingLot.parkingSpotFactory.MotorcycleParkingSpot;
import org.systemDesign.ParkingLot.paymentStrategy.PaymentStrategy;
import org.systemDesign.ParkingLot.paymentStrategy.UPIPayment;
import org.systemDesign.ParkingLot.vehicleFactory.Car;
import org.systemDesign.ParkingLot.vehicleFactory.Vehicle;

public class Driver {
    public static void main(String[] args) throws InterruptedException{
        //-----------SYSTEM INITIALIZATION-----------//
        System.out.println("\n======PARKING LOT SYSTEM DEMO========\n");

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addParkingSpot(new HandicappedParkingSpot(1));
        parkingLot.addParkingSpot(new CompactParkingSpot(2));
        parkingLot.addParkingSpot(new LargeParkingSpot(3));
        parkingLot.addParkingSpot(new MotorcycleParkingSpot(4));

        DisplayBoard board = new DisplayBoard(1);
        parkingLot.addDisplayBoard(board);


        Entrance entrance = new Entrance(1);
        Exit exit = new Exit(1);

        //---------------SCENARIO 1: Customer Enters, PARKS -----------
        System.out.println("\n-----SCENARIO 1: Customer enters and parks a car\n");

        Vehicle car = new Car("KA-01-HH-1234");
        System.out.println("--> Car "+ car.getLicenceNo() +" arrives at Entrance");
        ParkingTicket ticket1 = entrance.getTicket(car);

        System.out.println("--> Updating display board after parking");
        board.update(parkingLot.getAllSpots());
        board.showFreeSlots();

        //---------------SCENARIO 2: Customer Exits and pays -----------
        System.out.println("\n-----SCENARIO 2: Customer exits and pays\n");

        System.out.println("-> Car "+ car.getLicenceNo() +" proceeds to exit panel");
        Thread.sleep(1500);
        PaymentStrategy paymentStrategy = new UPIPayment(exit.calculateFee(ticket1),"123456@ybl");
        exit.validateTicket(ticket1,paymentStrategy);

        System.out.println("-> Updating display board after exit:");
        board.update(parkingLot.getAllSpots());
        board.showFreeSlots();

    }
}
