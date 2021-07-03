import controller.AirportController;
import controller.FlightController;
import model.*;
import utils.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void menu(){

        /*
        Poner main en paquete
        Crear Clase menu
        No sobrecargar  Main
        No crear variables para llenado de datos base
        Agregar mas comentarios
        Add try and catch
        */
        /////////////////////////////////////////////////////////////////
        ArrayList<Flight> flights = new ArrayList<>();
        ArrayList<AircraftType> aircraftTypes = new ArrayList<>();
        ArrayList<Airport> airports = new ArrayList<>();
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        ArrayList<Airline> airlines = new ArrayList<>();
        BasicData basicData = new BasicData();
        AirportController airportController = new AirportController();
        FlightController flightController = new FlightController();

        //SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

        Date date = new Date();

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
        airlines.add(airline1);
        airlines.add(airline2);

        Aircraft aircraft1 = basicData.aircraftCreation(1,aircraftType1);
        Aircraft aircraft2 = basicData.aircraftCreation(2,aircraftType2);
        aircrafts.add(aircraft1);
        aircrafts.add(aircraft2);


        Airport airport1 = airportController.createAirport(1,"Ilopango Airport", city1,aircraftTypes);
        Airport airport2 = airportController.createAirport(2, "Berlin Airport", city2,aircraftTypes);
        airports.add(airport1);
        airports.add(airport2);

        Flight flight1 = flightController.createFlight(14767);
        flight1.setStatus("Ontime");
        flight1.setAirline(airline1.getName());
        flight1.setAircraft(aircraft1);
        flight1.setDeparture(airport1.getName());//Departure
        flight1.setArrival(airport2.getName());//Arrival
        flight1.setDepartureDate(date);
        flight1.setDepartureTime(date);
        flight1.setArriveDate(date);
        flight1.setArriveTime(date);
        flight1.setCityOri(airport1.getCity().getName());
        flight1.setCityDest(airport2.getCity().getName());
        flight1.setCountryOri(airport1.getCity().getCountry().getName());
        flight1.setCountryDest(airport2.getCity().getCountry().getName());

        Flight flight2 = flightController.createFlight(25679);
        flight2.setStatus("Ontime");
        flight2.setAirline(airline2.getName());
        flight2.setAircraft(aircraft2);
        flight2.setDeparture(airport2.getName());//departure
        flight2.setArrival(airport1.getName());//arrival
        flight2.setDepartureDate(date);
        flight2.setDepartureTime(date);
        flight2.setArriveDate(date);
        flight2.setArriveTime(date);
        flight2.setCityOri(airport2.getCity().getName());
        flight2.setCityDest(airport1.getCity().getName());
        flight2.setCountryOri(airport2.getCity().getCountry().getName());
        flight2.setCountryDest(airport1.getCity().getCountry().getName());

        flights.add(flight1);
        flights.add(flight2);

        int flightOption;
        int selectedFlight;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("--------Select an Option------------");
            System.out.println("1 List Flights");
            System.out.println("2 Add Flight");
            System.out.println("3 Add from File");
            System.out.println("4 Update Flight");
            System.out.println("5 Generate report by date");
            System.out.println("6 Generate Flight Report");
            System.out.println("7 Exit");
            System.out.println("-------------------------------------");
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

    public static void main(String[] args) {
        menu();
    }
}
