package view;

import model.Aircraft;

import java.util.ArrayList;

public class AircraftView {
    public void showAircraft(ArrayList<Aircraft> aircraftList){
        for (Aircraft aircraft: aircraftList){
            System.out.println(aircraft.getId() + "for: " +aircraft.getAircraftType().getModel());
        }


    }
}
