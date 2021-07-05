package utils;

import controller.AirportController;
import controller.FlightController;
import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BaseDataCreation {

    public static ArrayList<AircraftType> createTypes(){
        ArrayList<AircraftType>aircraftTypes = new ArrayList<>();
        BasicDataInterface basicData =  new BasicData();
        AircraftType aircraftType1 = basicData.aircraftTypeCreation(1,"Cesna 172",12, 900);
        AircraftType aircraftType2 = basicData.aircraftTypeCreation(1,"Cesna 170",16, 1200);
        aircraftTypes.add(aircraftType1);
        aircraftTypes.add(aircraftType2);
        return aircraftTypes;
    }

    public static ArrayList<Airport> createAirportList(){
        ArrayList<Airport> airports = new ArrayList<>();
        ArrayList<AircraftType> aircraftTypes= createTypes();
        AirportController airportController = new AirportController();
        Airport airport1 = airportController.createAirport(1,"Ilopango Airport", "Ilopango", "El Salvador",aircraftTypes);
        Airport airport2 = airportController.createAirport(2, "Berlin Airport", "Berlin", "Germany",aircraftTypes);
        airports.add(airport1);
        airports.add(airport2);
        return airports;
    }

    public static ArrayList<Airline> createAirlineList(){
        BasicData basicData =  new BasicData();
        ArrayList<Airline> airlines = new ArrayList<>();
        Airline airline1 = basicData.airlineCreation(1,"Delta");
        Airline airline2 = basicData.airlineCreation(2, "Avianca");
        airlines.add(airline1);
        airlines.add(airline2);
        return airlines;
    }

    public static ArrayList<Aircraft> createAircraftList(){
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        BasicData basicData = new BasicData();
        Aircraft aircraft1 = basicData.aircraftCreation(1,createTypes().get(0));
        Aircraft aircraft2 = basicData.aircraftCreation(2,createTypes().get(1));
        aircrafts.add(aircraft1);
        aircrafts.add(aircraft2);
        return aircrafts;
    }

    public static ArrayList<Flight> createFlightList(){
        ArrayList<Flight> flights = new ArrayList<>();
        FlightController flightController = new FlightController();
        Flight flight1 = flightController.createFlight(14767);
        flight1.setStatus("Ontime");
        Date date = new Date();

        flight1.setAirline(createAirlineList().get(0).getName());
        flight1.setAircraft(createAircraftList().get(0));
        flight1.setDeparture(createAirportList().get(0).getName());//Departure
        flight1.setArrival(createAirportList().get(1).getName());//Arrival
        flight1.setDepartureDate(date);
        flight1.setDepartureTime(date);
        flight1.setArriveDate(date);
        flight1.setArriveTime(date);
        flight1.setCityOri(createAirportList().get(0).getCity());
        flight1.setCityDest(createAirportList().get(1).getCity());
        flight1.setCountryOri(createAirportList().get(0).getCountry());
        flight1.setCountryDest(createAirportList().get(1).getCountry());

        Flight flight2 = flightController.createFlight(25679);
        flight2.setStatus("Ontime");
        flight2.setAirline(createAirlineList().get(1).getName());
        flight2.setAircraft(createAircraftList().get(1));
        flight2.setDeparture(createAirportList().get(1).getName());//departure
        flight2.setArrival(createAirportList().get(1).getName());//arrival
        flight2.setDepartureDate(date);
        flight2.setDepartureTime(date);
        flight2.setArriveDate(date);
        flight2.setArriveTime(date);
        flight2.setCityOri(createAirportList().get(1).getCity());
        flight2.setCityDest(createAirportList().get(0).getCity());
        flight2.setCountryOri(createAirportList().get(1).getCountry());
        flight2.setCountryDest(createAirportList().get(0).getCountry());

        flights.add(flight1);
        flights.add(flight2);
        return flights;
    }

    public static void showCases(){
        ArrayList<Airline> airlines = createAirlineList();
        ArrayList<Aircraft> aircrafts = createAircraftList();
        ArrayList<AircraftType> aircraftTypes = createTypes();
        ArrayList<Airport> airports = createAirportList();
        ArrayList<Flight> flights = createFlightList();
        BasicData basicData = new BasicData();
        AirportController airportController = new AirportController();
        FlightController flightController = new FlightController();

        int flightOption;
        int selectedFlight;
        Scanner sc = new Scanner(System.in);
        do{
            Menu.showMainMenu();
            flightOption=sc.nextInt();
            switch (flightOption){
                case 1:
                    flightController.showFlightList(flights);
                    break;
                case 2:
                    Flight flight = flightController.createFlightManually(aircrafts,airports,airlines);
                    flightController.addFlight(flights,flight);
                    break;
                case 3:
                    System.out.println("Adding fro file");
                    FileImporter fileImporter = new FileImporter();
                    flights.addAll(fileImporter.importFromFile(aircrafts));
                    break;
                case 4:
                    flightController.showFlightList(flights);
                    System.out.println("Type the Flight number");
                    selectedFlight=sc.nextInt();
                    Flight selected = flightController.findFlightByNumber(selectedFlight, flights);
                    flightController.updateFlight(selected);
                    break;
                case 5:
                    flightController.showFlightList(flights);
                    System.out.println("Type date in format(dd/mm/yy)");
                    String strDate = sc.next();
                    FlightSelector flightSelector = new FlightSelector();
                    ArrayList<Flight> myFlights = flightSelector.findFlightByDate(flights,strDate);
                    flightController.generateDateReport(myFlights);
                    break;
                case 6:
                    flightController.showFlightList(flights);
                    System.out.println("Type the Flight number");
                    selectedFlight=sc.nextInt();
                    Flight reportFlight = flightController.findFlightByNumber(selectedFlight, flights);
                    flightController.generateFlightReport(reportFlight);
                default:
                    break;
            }
        }while (flightOption != 7);
    }

}
