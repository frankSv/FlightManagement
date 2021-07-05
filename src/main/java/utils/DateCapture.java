package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCapture implements DateCaptureInterface{

    @Override
    public Date dateCapturer(String strData){
        var format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = format.parse(strData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public Date timeCapturer(String strTime){
        var format = new SimpleDateFormat("hh:mm");
        Date time = null;
        try {
            time = format.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    @Override
    public String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }


}
