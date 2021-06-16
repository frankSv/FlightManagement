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
import java.util.Date;
import java.util.Scanner;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightController {
    private Flight flight;
    private FlightView flightView = new FlightView();

    public Flight createFlight(int number){
        Flight flight = new Flight();
        flight.setNumber(number);
        return flight;
    }


    public Flight createFlightManually(ArrayList<Aircraft> aircrafts, ArrayList<Airport> airports, ArrayList<Airline> airlines){
        Flight flight = new Flight();
        int selection;
        String strDate = "";
        DateCapture dateCapture = new DateCapture();
        AircraftView aircraftView = new AircraftView();
        AirportView airportView = new AirportView();
        AirlineView airlineView= new AirlineView();
        AircraftController aircraftController = new AircraftController();
        AirportController airportController = new AirportController();
        AirlineController airlineController = new AirlineController();

        Scanner sc = new Scanner(System.in);

        System.out.println("Type the Flight number");
        flight.setNumber(sc.nextInt());

        System.out.println("Set Status, type Ontime, Cancelled, Fliying, Delayed or Landed");
        flight.setStatus(sc.next());

        System.out.println("Select an aircraft to add");
        aircraftView.showAircraft(aircrafts);
        selection = sc.nextInt();
        flight.setAircraft(aircraftController.selectedAircraft(aircrafts,selection));

        System.out.println("Select an airline to add");
        airlineView.showAirlines(airlines);
        selection = sc.nextInt();
        flight.setAirline(airlineController.selectedAirline(airlines,selection).getName());

        System.out.println("Select departure airport ");
        airportView.showAirports(airports);
        selection = sc.nextInt();
        flight.setDeparture(airportController.selectedAirport(airports,selection).getName());

        System.out.println("Select arrival airport");
        airportView.showAirports(airports);
        selection = sc.nextInt();
        flight.setArrival(airportController.selectedAirport(airports,selection).getName());

        System.out.println("Type departure date (dd/mm/yyyy)");
        strDate = sc.next();
        flight.setDepartureDate(dateCapture.dateCapturer(strDate));

        System.out.println("Type arrival date (dd/mm/yyyy)");
        strDate = sc.next();
        flight.setArriveDate(dateCapture.dateCapturer(strDate));

        System.out.println("Type departure time (HH:mm)");
        strDate = sc.next();
        flight.setDepartureTime(dateCapture.timeCapturer(strDate));

        System.out.println("Type arrival time (HH:mm)");
        strDate = sc.next();
        flight.setArriveTime(dateCapture.timeCapturer(strDate));

        return flight;
    }

    public Flight findFlightByNumber(int number, ArrayList<Flight> flights){
        Flight myFlight = new Flight();
        for(Flight flight:flights){
            if(flight.getNumber()==number){
                myFlight = flight;
            }
        }
        return myFlight;
    }

    public Flight updateFlight(int number, ArrayList<Flight> flights){

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

    public void showFlightView(Flight flight){
        flightView.showFlight(flight);
    }

    public void showFlightList(ArrayList<Flight> flights){
        flightView.showFlights(flights);
    }

    public ArrayList<Flight> addFlight(ArrayList<Flight> flights, Flight flight){
        ArrayList<Flight>flightList = flights;
        flightList.add(flight);
        return flightList;
    }
}
