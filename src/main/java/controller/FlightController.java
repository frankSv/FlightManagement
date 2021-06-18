package controller;

import lombok.*;
import model.Aircraft;
import model.Airline;
import model.Airport;
import model.Flight;
import utils.DateCapture;
import utils.ReportUtil;
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
        Airport departureAirport = airportController.selectedAirport(airports,selection);
        flight.setDeparture(departureAirport.getName());
        flight.setCityOri(departureAirport.getCity().getName());
        flight.setCountryOri(departureAirport.getCity().getCountry().getName());


        System.out.println("Select arrival airport");
        airportView.showAirports(airports);
        selection = sc.nextInt();
        Airport arrivalAirport = airportController.selectedAirport(airports,selection);
        flight.setArrival(arrivalAirport.getName());
        flight.setCityDest(arrivalAirport.getCity().getName());
        flight.setCountryDest(arrivalAirport.getCity().getCountry().getName());


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

    public Flight updateFlight(Flight flight){
        Scanner sc = new Scanner(System.in);
        int updateOption;
        System.out.println("-----------Update Options----------------");
        System.out.println("1 Set Status as Ontime");
        System.out.println("2 Set Status as Delayed");
        System.out.println("3 Set Status as Cancelled");
        System.out.println("4 Set Status as Landed");
        System.out.println("5 Return to main Menu");
        System.out.println("____________________________________________");
        do{
            updateOption = sc.nextInt();
            switch (updateOption){
                case 1:
                    flight.setStatus("Ontime");
                    System.out.println("Flight set as Ontime");
                    updateOption = 5;
                    break;
                case 2:
                    flight.setStatus("Delayed");
                    updateDateTime(flight);
                    System.out.println("Flight set as Delayed");
                    updateOption = 5;
                    break;
                case 3:
                    setCancelled(flight);
                    System.out.println("Flight set as Cancelled");
                    System.out.println(flight.getCancelReason());
                    updateOption = 5;
                    break;
                case 4:
                    setLanded(flight);
                    System.out.println("Flight is landed");
                    updateOption = 5;
                    break;
                default:
                    break;
            }
        }while (updateOption!=5);
        return flight;
    }

    public void updateDateTime(Flight flight){
        String strDate = "";
        String incident = "No incident";
        DateCapture dateCapture = new DateCapture();
        Scanner sc = new Scanner(System.in);

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

        System.out.println("Type the Incident if exist");
        incident = sc.next();
        flight.setIncident(incident);

    }

    public void setLanded(Flight flight){
        flight.setStatus("Landed");
        ReportUtil report = new ReportUtil();
        System.out.println("Generating Report");
        report.generateReport(flight);
    }

    public void setCancelled(Flight flight){
        flight.setStatus("Cancelled");
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the Cancellation Reason");
        flight.setCancelReason(sc.nextLine());
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
