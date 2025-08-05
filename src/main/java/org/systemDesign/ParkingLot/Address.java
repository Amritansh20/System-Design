package org.systemDesign.ParkingLot;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    private int zipcode;
    private String street;
    private String city;
    private String state;
    private String country;
}
