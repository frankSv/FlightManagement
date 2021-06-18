package model;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private int number;
    private String status;
    private Date departureDate;
    private Date departureTime;
    private Date arriveDate;
    private Date arriveTime;
    private Aircraft aircraft;
    private String airline;
    private String departure;
    private String arrival;
    private String incident = "No incident";
    private String cancelReason = " ";
}
