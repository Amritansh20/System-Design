package org.systemDesign.ParkingLot;

import org.systemDesign.ParkingLot.parkingSpotFactory.ParkingSpot;

public class Admin extends Account{

    public boolean addParkingSpot(ParkingSpot spot){
        return true;
    }

    public boolean addDisplayBoard(DisplayBoard board){
        return  true;
    }

    public boolean addEntrance(Entrance entrance){
        return true;
    }

    public boolean addExit(Exit exit){
        return true;
    }
    @Override
    public boolean resetPassword() {
        return true;
    }
}
