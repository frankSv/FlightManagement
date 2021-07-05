package model;

import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    private int id;
    private String name;
    private String city;
    private String country;
    private ArrayList<AircraftType> types = new ArrayList<>();

}
