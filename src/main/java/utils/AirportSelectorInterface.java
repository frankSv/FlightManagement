package utils;

import model.Airport;

import java.util.ArrayList;

public interface AirportSelectorInterface {
    Airport selectedAirport(ArrayList<Airport> airports, int selection);
}
