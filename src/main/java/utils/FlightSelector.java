package utils;

import model.Flight;
import java.util.ArrayList;

public class FlightSelector implements FlightSelectorInterface{
    @Override
    public ArrayList<Flight> findFlightByDate(ArrayList<Flight> flights, String strDate) {
        ArrayList<Flight> myFlights= new ArrayList<>();
        DateCapture dateCapture = new DateCapture();
        for(Flight flight:flights){

            if(dateCapture.dateToString(flight.getDepartureDate()).equals(strDate)){
                myFlights.add(flight);
            }
        }
        return myFlights;
    }
}
