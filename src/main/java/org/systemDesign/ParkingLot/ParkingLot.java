package org.systemDesign.ParkingLot;

import org.systemDesign.ParkingLot.parkingSpotFactory.*;
import org.systemDesign.ParkingLot.vehicleFactory.*;

import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    public ParkingRate rate = new ParkingRate();
    private Map<Integer,ParkingSpot> spots = new LinkedHashMap<>();
    private Map<Integer,ParkingTicket> tickets = new HashMap<>();
    private List<DisplayBoard> boards = new ArrayList<>();

    // Singleton
    private ParkingLot(){}

    public static ParkingLot getInstance(){
        if(instance==null)
            return instance=new ParkingLot();

        return instance;
    }

    //add spots
    public void addParkingSpot(ParkingSpot s){
        spots.put(s.getId(),s);
    }

    // add display boards
    public void addDisplayBoard(DisplayBoard board){
        boards.add(board);
    }

    //find slot
    public ParkingSpot getParkingSlot(int id){
            return spots.get(id);
    }

    // Free up the spot
    public void freeSpots(int id){
        ParkingSpot spot = spots.get(id);
        if(spot!=null)
            spot.removeVehicle();
    }

    // Get all spots
    public Collection<ParkingSpot> getAllSpots(){
        return spots.values();
    }

    //Park Vehicle
    public ParkingTicket parkVehicle(Vehicle v){
        for(ParkingSpot s : spots.values()){
            if(s.isFree() && canFit(v,s)){
                s.assignVehicle(v);
                ParkingTicket ticket = new ParkingTicket(s.getId(), v);
                tickets.put(ticket.getTicketNo(), ticket);
                return ticket;
            }
        }
        System.out.println("Sorry, parking lot is full. New cars cannot be parked");
        return null;
    }

    public boolean canFit(Vehicle v, ParkingSpot s){
        if(v instanceof Motorcycle && s instanceof MotorcycleParkingSpot)
            return true;

        if((v instanceof Vans || v instanceof Truck) && s instanceof LargeParkingSpot)
            return true;

        if(v instanceof Car && (s instanceof CompactParkingSpot || s instanceof HandicappedParkingSpot))
            return true;

        return false;
    }
}
