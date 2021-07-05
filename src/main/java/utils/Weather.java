package utils;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private String temperture;
    private String windSpeed;
    private String cloudy;
}

