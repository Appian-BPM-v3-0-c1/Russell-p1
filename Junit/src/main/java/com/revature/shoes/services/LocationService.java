package com.revature.shoes.services;

import com.revature.shoes.daos.LocationDAO;

public class LocationService {
    private final LocationDAO locationDAO;

    public LocationService(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public LocationDAO getLocationDAO(){
        return locationDAO;
    }
}
