package controller;

import lombok.*;
import model.Aircraft;
import model.Airline;
import model.Airport;
import model.Flight;
import utils.DateCapture;
import view.AircraftView;
import view.AirlineView;
import view.AirportView;
import view.FlightView;

import java.util.ArrayList;
import java.util.Scanner;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightController {
    private Flight flight;
    private FlightView flightView;

    public Flight createFlight(int number){
        return new Flight();
    }


    public Flight createFlightManually(ArrayList<Aircraft> aircrafts, ArrayList<Airport> airports, ArrayList<Airline> airlines){
        Flight flight = null;
        int selection;
        String inputDate;
        DateCapture dateCapture = new DateCapture();
        AircraftView aircraftView = new AircraftView();
        AirportView airportView = new AirportView();
        AirlineView airlineView= new AirlineView();
        AircraftController aircraftController = new AircraftController();
        AirportController airportController = new AirportController();
        AirlineController airlineController = new AirlineController();

        Scanner sc = new Scanner(System.in);

        System.out.println("Select an aircraft to add");
        aircraftView.showAircraft(aircrafts);
        selection = sc.nextInt();
        flight.setAircraft(aircraftController.selectedAircraft(aircrafts,selection));

        System.out.println("Select an airline to add");
        airlineView.showAirlines(airlines);
        selection = sc.nextInt();
        flight.setAirline(airlineController.selectedAirline(airlines,selection));

        System.out.println("Select departure airport ");
        airportView.showAirports(airports);
        selection = sc.nextInt();
        flight.setDeparture(airportController.selectedAirport(airports,selection));

        System.out.println("Select arrival airport");
        airportView.showAirports(airports);
        selection = sc.nextInt();
        flight.setArrival(airportController.selectedAirport(airports,selection));

        System.out.println("Type departure date (dd/mm/yyyy)");
        inputDate = sc.nextLine();
        flight.setDepartureDate(dateCapture.dateTimeCapturer(inputDate));

        System.out.println("Type arrival date (dd/mm/yyyy)");
        inputDate = sc.nextLine();
        flight.setArriveDate(dateCapture.dateTimeCapturer(inputDate));

        System.out.println("Type departure time (HH:mm)");
        inputDate = sc.nextLine();
        flight.setDepartureTime(dateCapture.dateTimeCapturer(inputDate));

        System.out.println("Type arrival time (HH:mm)");
        inputDate = sc.nextLine();
        flight.setArriveTime(dateCapture.dateTimeCapturer(inputDate));

        return flight;
    }

    public String  setStatus(Flight flight, String status){
        Scanner sc = new Scanner(System.in);
        String incidentDescription;
        System.out.println("Type the inident: ");
        incidentDescription = sc.nextLine();
        flight.setStatus(status);
        return incidentDescription;
    }

    public void flightMenu(int option){
        do{
            System.out.println("--------Select an Option------------");
            System.out.println("1 List Flights");
            System.out.println("2 Add Flight");
            System.out.println("3 Exit");
        }while (option != 3);
    }

    public ArrayList<Flight> addFlight(Flight flight){
        ArrayList<Flight>flights = new ArrayList<>();
        flights.add(flight);
        return flights;
    }
}
