package utils;

import model.*;

public interface BasicDataInterface {
    Country countryCreation(int id, String name);

    City cityCreation(int id, String name, Country country);

    AircraftType aircraftTypeCreation(int id, String model, int capacity, int gasRange);

    Airline airlineCreation(int id, String name);

    Aircraft aircraftCreation(int id, AircraftType type);

}
