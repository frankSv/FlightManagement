package model;

import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    int id;
    String name;
    ArrayList<Aircraft> types = new ArrayList<>();

}
