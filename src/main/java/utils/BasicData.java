package utils;


import model.*;

public class BasicData implements BasicDataInterface{


    @Override
    public Country countryCreation(int id, String name){
        return new Country(id, name);
    }

    @Override
    public City cityCreation(int id, String name, Country country){
        return new City(id, name, country);
    }

    @Override
    public AircraftType aircraftTypeCreation(int id, String model, int capacity, int gasRange){
        return new AircraftType(id,model,capacity,gasRange);
    }

    @Override
    public Airline airlineCreation(int id, String name){
        return new Airline(id,name);
    }

    @Override
    public Aircraft aircraftCreation(int id, AircraftType type){
        return new Aircraft(id, type);
    }

}
