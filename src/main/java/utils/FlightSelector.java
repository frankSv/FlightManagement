package utils;

import model.Flight;

import java.util.ArrayList;
import java.util.Date;

public class FlightSelector implements FlightSelectorInterface{
    @Override
    public ArrayList<Flight> findFlightByDate(ArrayList<Flight> flights, String strDate) {
        Date date;
        DateCapture dateCapture = new DateCapture();
        ArrayList<Flight> myFlights= new ArrayList<>();
        date = dateCapture.dateCapturer(strDate);
        for(Flight flight:flights){
            if(flight.getDepartureDate().compareTo(date)==0){
                myFlights.add(flight);
            }
        }
        return myFlights;

    }
}
