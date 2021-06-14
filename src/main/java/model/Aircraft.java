package model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {
    private int id;
    private AircraftDescription aircraftDescription;
}
