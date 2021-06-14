package model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AircraftDescription {
    int id;
    String model;
    int capacity;
    int gasRange;

}
