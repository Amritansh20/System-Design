package org.systemDesign.ParkingLot.parkingSpotFactory;

import org.systemDesign.ParkingLot.vehicleFactory.Vehicle;

public class HandicappedParkingSpot extends ParkingSpot{

    public HandicappedParkingSpot(int id) {
        super(id);
    }

    @Override
    public boolean assignVehicle(Vehicle v) {
        if(isFree){
            System.out.println("Allocated Handicapped slot "+id +" to "+v.getLicenceNo());
            this.vehicle=v;
            isFree=false;
            return true;
        }
        return false;
    }

    @Override
    public void printMesaage() {
        System.out.println("Handicapped parking spot created");
    }
}
