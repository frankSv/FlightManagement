package utils;

import lombok.SneakyThrows;
import model.DateFlight;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCapture {
    @SneakyThrows
    public Date dateTimeCapturer(String strData){
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date date = format.parse(strData);
        return date;
    }

    @SneakyThrows
    public Date timeCapturer(String strTime){
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        Date time = format.parse(strTime);
        return time;
    }



}
