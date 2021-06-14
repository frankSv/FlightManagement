package model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {
    int id;
    AircraftDescription aircraftDescription;
}
