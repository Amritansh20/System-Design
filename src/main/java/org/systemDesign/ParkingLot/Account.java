package org.systemDesign.ParkingLot;

public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus accountStatus;
    private Person person;

    public abstract boolean resetPassword();
}
