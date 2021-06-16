import controller.AirportController;
import controller.FlightController;
import model.*;
import utils.BasicData;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void menu(){
        int flightOption;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("--------Select an Option------------");
            System.out.println("1 List Flights");
            System.out.println("2 Add Flight");
            System.out.println("3 Exit");
            flightOption=sc.nextInt();
            switch (flightOption){
                case 1:
                    System.out.println("Flights list");
                case 2:


            }
        }while (flightOption != 3);
    }

    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<AircraftType> aircraftTypes = new ArrayList<>();
        BasicData basicData = new BasicData();
        AirportController airportController = new AirportController();
        FlightController flightController = new FlightController();

        Country country1 = basicData.countryCreation(1,"El Salvador");
        Country country2 = basicData.countryCreation(2,"Germany");

        City city1 = basicData.cityCreation(1,"San Salvador", country1);
        City city2 = basicData.cityCreation(2,"Berlin", country2);

        AircraftType aircraftType1 = basicData.aircraftTypeCreation(1,"Cesna 172",12, 900);
        AircraftType aircraftType2 = basicData.aircraftTypeCreation(1,"Cesna 170",16, 1200);

        aircraftTypes.add(aircraftType1);
        aircraftTypes.add(aircraftType2);

        Airline airline1 = basicData.airlineCreation(1,"Delta");
        Airline airline2 = basicData.airlineCreation(2, "Avianca");

        Aircraft aircraft1 = basicData.aircraftCreation(1,aircraftType1);
        Aircraft aircraft2 = basicData.aircraftCreation(2,aircraftType2);

        Airport airport1 = airportController.createAirport(1,"Ilopango Airport", city1,aircraftTypes);
        Airport airport2 = airportController.createAirport(2, "Berlin Airport", city2,aircraftTypes);

        Flight flight1 = flightController.createFlight(1);
        flight1.setStatus("Ontime");
        flight1.setAirline(airline1);
        flight1.setAircraft(aircraft1);
        flight1.setDeparture(airport1);
        flight1.setArrival(airport2);

        Flight flight2 = flightController.createFlight(2);
        flight1.setStatus("Ontime");
        flight1.setAirline(airline2);
        flight1.setAircraft(aircraft2);
        flight1.setDeparture(airport2);
        flight1.setArrival(airport1);

        flights.add(flight1);
        flights.add(flight2);


    }




}
