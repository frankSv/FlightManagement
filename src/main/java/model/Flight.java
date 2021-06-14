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
    private Aircraft aircraft;
    private Airline airline;
    private Airport origin;
    private Airport destination;
}
