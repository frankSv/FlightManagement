package controller;

import model.Airline;

import java.util.ArrayList;

public class AirlineController {
    //Add Explanation
    public Airline selectedAirline(ArrayList<Airline> airlines, int selection){
        Airline selected = new Airline();
        for (Airline airline: airlines){
            if(airline.getId()==selection){
                selected = airline;
            }
        }
        return selected;
    }

}
