package org.systemDesign.ParkingLot.parkingSpotFactory;

import org.systemDesign.ParkingLot.vehicleFactory.Vehicle;

public class CompactParkingSpot extends ParkingSpot{
    public CompactParkingSpot(int id) {
        super(id);
    }

    @Override
    public boolean assignVehicle(Vehicle v) {
        if(isFree){
            System.out.println("Allocated Compact slot "+id +" to "+v.getLicenceNo());
            this.vehicle=v;
            isFree=false;
            return true;
        }
        return false;
    }

    @Override
    public void printMesaage() {
        System.out.println("Compact parking spot created");
    }
}
