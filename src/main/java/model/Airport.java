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
    private ArrayList<Aircraft> types = new ArrayList<>();

}
