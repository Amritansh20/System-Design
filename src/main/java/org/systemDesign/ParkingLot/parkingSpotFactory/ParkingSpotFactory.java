package org.systemDesign.ParkingLot.parkingSpotFactory;

public class ParkingSpotFactory {
    public ParkingSpot createParkingSpot(int id, String type){
            if(type==null)
                return null;

            if(type.equalsIgnoreCase("Compact"))
                return new CompactParkingSpot(id);
            else if(type.equalsIgnoreCase("Handicapped"))
                return new HandicappedParkingSpot(id);
            else if(type.equalsIgnoreCase("Large"))
                return new LargeParkingSpot(id);
            else if(type.equalsIgnoreCase("Motorcycle"))
                return new MotorcycleParkingSpot(id);
            else
                return null;
    }
}
