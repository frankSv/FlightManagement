package controller;

import model.*;
import view.AirportView;
import java.util.ArrayList;
public class AirportController {
    public Airport createAirport(int id, String name, String city, String country, ArrayList<AircraftType> types){
        return new Airport(id,name,city, country,types);
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

    public void showAirports(ArrayList<Airport> airports){
        AirportView airportView = new AirportView();
        airportView.showAirports(airports);
    }

}
