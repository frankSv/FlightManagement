import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import utils.DateCapture;
import utils.Weather;
import utils.WeatherData;

import java.util.Date;

class Testing {
    private final Date dateNow = new Date();
    private final DateCapture dateTest = new DateCapture();
    private final WeatherData weatherData = new WeatherData();
    private final Weather actualWeather = new Weather("29","68","Cloudy");

    @Test
    void dateStringTest() {
        assertEquals("05/07/2021", dateTest.dateToString(dateNow));
    }

    @Test
    void weatherRecieverTest(){
        assertEquals(actualWeather,weatherData.getWeatherData());
    }

}