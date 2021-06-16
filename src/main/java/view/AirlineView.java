package view;

import model.Airline;

import java.util.ArrayList;

public class AirlineView {
    public void showAirlines(ArrayList<Airline> airlines){
        for(Airline airline:airlines){
            System.out.println(airline.getId()+" for " + airline.getName());
        }
    }
}
