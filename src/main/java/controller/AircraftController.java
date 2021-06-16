package controller;

import model.Aircraft;

import java.util.ArrayList;

public class AircraftController {
    public Aircraft selectedAircraft(ArrayList<Aircraft> aircrafts, int selection){
        Aircraft selected = new Aircraft();
        for(Aircraft aircraft: aircrafts){
            if(aircraft.getId() == selection){
                selected = aircraft;
            }
        }
        return selected;
    }

}
