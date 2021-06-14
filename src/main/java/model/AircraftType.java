package model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AircraftType {
    int id;
    int number;
    Airline airline;
    Aircraft aircraft;

}
