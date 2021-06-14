package model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AircraftType {
    private int id;
    private int number;
    private Airline airline;
    private Aircraft aircraft;

}
