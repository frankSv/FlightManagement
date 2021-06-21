package utils;

import model.Airport;

import java.util.ArrayList;

public class AirportSelector implements AirportSelectorInterface{
    @Override
    public Airport selectedAirport(ArrayList<Airport> airports, int selection) {
        Airport selected = new Airport();
        for (Airport airport: airports){
            if(airport.getId()==selection){
                selected = airport;
            }
        }
        return selected;
    }
}
