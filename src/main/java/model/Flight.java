package model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private int id;
    private int number;
    private String status;
    private DateFlight departureDate;
    private DateFlight arriveDate;
    private Aircraft aircraft;
    private Airline airline;
    private Airport departure;
    private Airport arrival;
}
