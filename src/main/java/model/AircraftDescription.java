package model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AircraftDescription {
    private int id;
    private String model;
    private int capacity;
    private int gasRange;

}
