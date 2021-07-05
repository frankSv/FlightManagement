package view;

import model.Aircraft;
import model.Flight;
import utils.WeatherData;

import java.util.ArrayList;
import java.util.Date;

public class FlightView {
    public void showFlight(Flight flight){
        StringBuilder stringBuilder = new StringBuilder();
        WeatherData weatherData = new WeatherData();

        int number = flight.getNumber();
        String status = flight.getStatus();
        Date departureDate = flight.getDepartureDate();
        Date departureTime = flight.getDepartureTime();
        Date arriveDate = flight.getArriveDate();
        Date arriveTime = flight.getArriveTime();
        Aircraft aircraft = flight.getAircraft();
        String airline = flight.getAirline();
        String departure = flight.getDeparture();
        String arrival = flight.getArrival();
        String incident = flight.getIncident();

        stringBuilder.append(number);
        stringBuilder.append(" | ");
        stringBuilder.append(status);
        stringBuilder.append(" | ");
        stringBuilder.append(departureDate);
        stringBuilder.append(" | ");
        stringBuilder.append(departureTime);
        stringBuilder.append(" | ");
        stringBuilder.append(arriveDate);
        stringBuilder.append(" | ");
        stringBuilder.append(arriveTime);
        stringBuilder.append(" | ");
        stringBuilder.append(incident);
        stringBuilder.append(" | ");
        stringBuilder.append(flight.getCancelReason());
        stringBuilder.append(" | ");
        stringBuilder.append(aircraft.getAircraftType().getModel());
        stringBuilder.append(" | ");
        stringBuilder.append(aircraft.getAircraftType().getCapacity());
        stringBuilder.append(" | ");
        stringBuilder.append(aircraft.getAircraftType().getGasRange());
        stringBuilder.append("|");
        stringBuilder.append(weatherData.getWeatherData().getTemperture()+"°C");
        stringBuilder.append("|");
        stringBuilder.append(weatherData.getWeatherData().getWindSpeed()+"km/h");
        stringBuilder.append("|");
        stringBuilder.append(weatherData.getWeatherData().getCloudy());

        String flightInfo = stringBuilder.toString();
        System.out.println(flightInfo);

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void showFlights(ArrayList<Flight> flights){
        System.out.println("Flight Data");
        System.out.println("----------------------------------------------");
        for (Flight flight:flights){
            showFlight(flight);
        }
    }
}
