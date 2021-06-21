package utils;

import model.Flight;

import java.util.ArrayList;

public interface FlightSelectorInterface {
    ArrayList<Flight> findFlightByDate(ArrayList<Flight> flights, String StrDate);
}
