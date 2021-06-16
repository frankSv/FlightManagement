package view;

import model.Airport;

import java.util.ArrayList;

public class AirportView {
    public void showAirports(ArrayList<Airport> airports){
        for (Airport airport: airports){
            System.out.println(airport.getId() + "for: " +airport.getName());
        }
    }
}
