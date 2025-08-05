package org.systemDesign.ParkingLot;

import lombok.Getter;
import lombok.Setter;
import org.systemDesign.ParkingLot.paymentStrategy.Payment;
import org.systemDesign.ParkingLot.vehicleFactory.Vehicle;

import java.util.Date;

@Getter
@Setter
public class ParkingTicket {
    private static int ticketSeed =1000;
    private int ticketNo;
    private Vehicle vehicle;
    private int slotNo;
    private Date entryTime, exitTime;
    private Payment payment;
    private Double amount;
    private TicketStatus ticketStatus;

    public ParkingTicket(int slotNo, Vehicle v){
        this.ticketNo = ticketSeed++;
        this.slotNo=slotNo;
        this.vehicle=v;
        this.entryTime = new Date();
        ticketStatus = TicketStatus.ISSUED;
        v.assignTicket(this);
        System.out.println("Ticket Issued: "+ ticketNo);
    }


}
