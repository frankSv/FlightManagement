package controller;

import model.*;
import utils.EmailUtils;
import utils.ReportUtil;
import view.AirportView;

import java.util.ArrayList;
import java.util.Scanner;


public class AirportController {
    public Airport createAirport(int id, String name, City city, ArrayList<AircraftType> types){
        return new Airport(id,name,city,types);
    }

    public Airport selectedAirport(ArrayList<Airport> airports, int selection){
        Airport selected = new Airport();
        for (Airport airport: airports){
            if(airport.getId()==selection){
                selected = airport;
            }
        }

        return selected;
    }

    public void showAirports(ArrayList<Airport> airports){
        AirportView airportView = new AirportView();
        airportView.showAirports(airports);
    }

    public void generateAirportReport(ArrayList<Flight> flights, ArrayList<Airport> airports){
        Scanner sc = new Scanner(System.in);
        int selection;
        ArrayList<Flight> myAirportFlights= new ArrayList<>();
        Airport airport = new Airport();
        ReportUtil reportUtil = new ReportUtil();
        System.out.println("Select the Airport");
        showAirports(airports);
        selection = sc.nextInt();
        airport = selectedAirport(airports,selection);
        myAirportFlights = airportFlights(flights,airport);
        reportUtil.generateAirportReport(airport,myAirportFlights);

    }

    public ArrayList<Flight> airportFlights(ArrayList<Flight> flights, Airport airport){
        ArrayList<Flight>myFlights = new ArrayList<>();
        for (Flight flight:flights){
            if(flight.getDeparture()==airport.getName()||flight.getArrival()==airport.getName()){
                myFlights.add(flight);
            }
        }
        return myFlights;
    }

}
