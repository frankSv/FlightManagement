package utils;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private int windSpeed = 120;
    private int temperature = 32;
    private String skyCondition = "Cloudy";
}
