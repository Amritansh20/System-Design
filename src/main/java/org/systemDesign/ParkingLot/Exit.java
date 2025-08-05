package org.systemDesign.ParkingLot;

import org.systemDesign.ParkingLot.parkingSpotFactory.ParkingSpot;
import org.systemDesign.ParkingLot.paymentStrategy.CreditCardPayment;
import org.systemDesign.ParkingLot.paymentStrategy.PaymentContext;
import org.systemDesign.ParkingLot.paymentStrategy.PaymentStrategy;
import org.systemDesign.ParkingLot.paymentStrategy.UPIPayment;

import java.util.Date;

public class Exit {
    private int id;

    public Exit(int id){
        this.id=id;
    }

    public void validateTicket(ParkingTicket ticket, PaymentStrategy paymentStrategy){
        Date now = new Date();
        ticket.setExitTime(now);
        double hrs = (now.getTime() - ticket.getEntryTime().getTime())/3600000.0;
        double fee = ParkingLot.getInstance().rate.calculate(hrs,ticket.getVehicle(), ParkingLot.getInstance().getParkingSlot(ticket.getSlotNo()));
        ticket.setAmount(fee);
        System.out.printf("Ticket %d | Parked: %.2f hrs | Fee: $%.2f\n", ticket.getTicketNo(),hrs,fee);
        PaymentStrategy strategy = (fee>10)? new CreditCardPayment(fee,"dummy","233"):new UPIPayment(fee,"xyz@gmail.com");
        PaymentContext paymentContext = new PaymentContext(strategy);
        paymentContext.completeTxn();
        ParkingLot.getInstance().freeSpots(ticket.getSlotNo());
        ticket.setTicketStatus(TicketStatus.PAID);
    }

    public double calculateFee(ParkingTicket ticket){
        Date now = new Date();
        ticket.setExitTime(now);
        double hrs = (now.getTime() - ticket.getEntryTime().getTime())/3600000.0;
        double fee = ParkingLot.getInstance().rate.calculate(hrs,ticket.getVehicle(), ParkingLot.getInstance().getParkingSlot(ticket.getSlotNo()));
        return fee;
    }
}
