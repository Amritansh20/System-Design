package org.systemDesign.ParkingLot.parkingSpotFactory;

import lombok.Getter;
import org.systemDesign.ParkingLot.vehicleFactory.Vehicle;

@Getter
public abstract class ParkingSpot {
    protected int id;
    protected boolean isFree=true;
    protected Vehicle vehicle;

    public ParkingSpot(int id){
        this.id=id;
    }

    public abstract boolean assignVehicle(Vehicle v);

    public boolean removeVehicle(){
        if(!isFree && vehicle!=null){
            System.out.println("Slot "+id + " freed (was "+vehicle.getLicenceNo()+")");
            isFree=true;
            vehicle=null;
            return true;
        }
        return false;
    }

    public abstract void printMesaage();

}
