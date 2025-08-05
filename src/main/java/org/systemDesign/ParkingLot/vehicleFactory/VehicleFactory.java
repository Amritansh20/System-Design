package org.systemDesign.ParkingLot.vehicleFactory;

public class VehicleFactory {
    public Vehicle createVehicle(String type,String licenceNo){
        if(type==null)
            return null;

        if(type.equalsIgnoreCase("Car"))
            return new Car(licenceNo);
        else if(type.equalsIgnoreCase("Vans"))
            return new Vans(licenceNo);
        else if(type.equalsIgnoreCase("Truck"))
            return new Truck(licenceNo);
        else if(type.equalsIgnoreCase("Motorcycle"))
            return new Motorcycle(licenceNo);
        else
            return  null;
    }
}
