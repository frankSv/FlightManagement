package utils;

import controller.AircraftController;
import lombok.SneakyThrows;
import model.Aircraft;
import model.Flight;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class FileImporter {
    @SneakyThrows
    public void readingFile(){
        File flightData = new File("try.xlsx");
        FileInputStream fileInputStream = new FileInputStream(flightData);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIt = sheet.iterator();
        while (rowIt.hasNext()){
            Row row = rowIt.next();
            Iterator<Cell> cellIt = row.cellIterator();
            while (cellIt.hasNext()){
                Cell cell = cellIt.next();
                System.out.println(cell.toString());
            }
            System.out.println();
            fileInputStream.close();
        }
    }

    @SneakyThrows
    public ArrayList<Flight> importFromFile(ArrayList<Aircraft>aircrafts){
        AircraftController aircraftController = new AircraftController();
        File flightData = new File("try.xlsx");
        FileInputStream fileInputStream = new FileInputStream(flightData);
        ArrayList<Flight> flights = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(Row row:sheet){
            Flight flight = new Flight();
            for(int i=row.getFirstCellNum();i<=row.getLastCellNum();i++){
                Cell cell = row.getCell(i);
                if(i==0){
                    int number = (int) cell.getNumericCellValue();
                    flight.setNumber(number);
                }
                ////////////////////////////////////////////////
                if(i==1){
                    String status = cell.toString();
                    flight.setStatus(status);
                }
                ////////////////////////////////////////////////
                if(i==2){
                    Date depDate = cell.getDateCellValue();
                    flight.setDepartureDate(depDate);
                }////////////////////////////////////////////////
                if(i==3){
                    Date depTime = cell.getDateCellValue();
                    flight.setDepartureTime(depTime);
                }////////////////////////////////////////////////
                if(i==4){
                    Date arrDate = cell.getDateCellValue();
                    flight.setArriveDate(arrDate);
                }////////////////////////////////////////////////
                if(i==5){
                    Date arrTime = cell.getDateCellValue();
                    flight.setArriveTime(arrTime);
                }////////////////////////////////////////////////
                if(i==6){
                    int airCraftId = (int) cell.getNumericCellValue();
                    flight.setAircraft(aircraftController.selectedAircraft(aircrafts,airCraftId));
                }////////////////////////////////////////////////
                if(i==7){
                    String airline = cell.toString();
                    flight.setAirline(airline);
                }////////////////////////////////////////////////
                if(i==8){
                    String airpDep = cell.toString();
                    flight.setDeparture(airpDep);
                }////////////////////////////////////////////////
                if(i==9){
                    String airpArr = cell.toString();
                    flight.setArrival(airpArr);
                }
                ////////////////////////////////////////////////
                if(i==10){
                    String cityDep = cell.toString();
                    flight.setCityOri(cityDep);
                }
                ////////////////////////////////////////////////
                if(i==11){
                    String cityArr = cell.toString();
                    flight.setCountryDest(cityArr);
                }
                ////////////////////////////////////////////////
                if(i==12){
                    String countDep = cell.toString();
                    flight.setCountryOri(countDep);
                }
                ////////////////////////////////////////////////
                if(i==13){
                    String countArr = cell.toString();
                    flight.setCountryDest(countArr);
                }

            }
            flights.add(flight);
        }
        fileInputStream.close();
        return flights;
    }

}
