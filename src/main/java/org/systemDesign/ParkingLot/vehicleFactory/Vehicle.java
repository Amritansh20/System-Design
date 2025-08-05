package org.systemDesign.ParkingLot.vehicleFactory;

import lombok.Getter;
import org.systemDesign.ParkingLot.ParkingTicket;

@Getter
public abstract class Vehicle {
    private String licenceNo;
    private ParkingTicket ticket;

    public Vehicle(String licenceNo){
        this.licenceNo=licenceNo;
    }
    public void assignTicket(ParkingTicket ticket){
        this.ticket=ticket;
    }

    abstract void printMessage();
}
