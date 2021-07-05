package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class WeatherData implements WeatherDataInterface{

    @Override
    public Weather getWeatherData() {
        JSONParser jsonParser = new JSONParser();

        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader("weather.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
            String temp = (String) jsonObject.get("Temperature");
            String speed = (String) jsonObject.get("Wind Speed");
            String visibility = (String) jsonObject.get("Visibility");
            Weather weather = new Weather(temp,speed,visibility);
        return weather;
    }
}
