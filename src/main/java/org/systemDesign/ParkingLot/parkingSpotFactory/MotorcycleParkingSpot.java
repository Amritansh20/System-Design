package org.systemDesign.ParkingLot.parkingSpotFactory;

import org.systemDesign.ParkingLot.vehicleFactory.Vehicle;

public class MotorcycleParkingSpot extends ParkingSpot{
    public MotorcycleParkingSpot(int id) {
        super(id);
    }

    @Override
    public boolean assignVehicle(Vehicle v) {
        if(isFree){
            System.out.println("Allocated Motorcycle slot "+id +" to "+v.getLicenceNo());
            this.vehicle=v;
            isFree=false;
            return true;
        }
        return false;
    }

    @Override
    public void printMesaage() {
        System.out.println("Motorcycle parking spot created");

    }
}
