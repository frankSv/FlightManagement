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
    private City city;
    private ArrayList<AircraftType> types = new ArrayList<>();

}
