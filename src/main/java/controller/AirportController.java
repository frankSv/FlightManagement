package controller;

import model.*;

import java.util.ArrayList;

public class AirportController {
    public Airport createAirport(int id, String name, City city, ArrayList<AircraftType> types){
        return new Airport(id,name,city,types);
    }

    public Airport selectedAirport(ArrayList<Airport> airports, int selection){
        Airport selected = new Airport();
        for (Airport airport: airports){
            if(airport.getId()==selection){
                selected = airport;
            }
        }

        return selected;
    }


}
