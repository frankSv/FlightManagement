package utils;

import lombok.SneakyThrows;
import model.Aircraft;
import model.Airport;
import model.Flight;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class ReportUtil {
    @SneakyThrows
    public void generateReport(Flight flight){
        String flightReportName = "Flight " + flight.getNumber() + "report.xlsx";
        String[] header = new String[]{"Number",
                                        "Status",
                                        "Airline",
                                        "Model",
                                        "Capacity",
                                        "Gas Range",
                                        "Departure City",
                                        "Arrival City",
                                        "Departure Country",
                                        "Arrival Country"};
        int number;

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i<header.length;i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header[i]);
        }

        int numRow = 1;
        Row row = sheet.createRow(numRow++);
        row.createCell(0).setCellValue(flight.getNumber());
        row.createCell(1).setCellValue(flight.getStatus());
        row.createCell(2).setCellValue(flight.getAirline());
        row.createCell(3).setCellValue(flight.getAircraft().getAircraftType().getModel());
        row.createCell(4).setCellValue(flight.getAircraft().getAircraftType().getCapacity());
        row.createCell(5).setCellValue(flight.getAircraft().getAircraftType().getGasRange());
        row.createCell(6).setCellValue(flight.getCityOri());
        row.createCell(7).setCellValue(flight.getCityDest());
        row.createCell(8).setCellValue(flight.getCountryOri());
        row.createCell(9).setCellValue(flight.getCountryDest());

        for (int i = 0; i<header.length;i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream file = null;
        try {
            file = new FileOutputStream(flightReportName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        workbook.write(file);
        file.close();
        workbook.close();
        System.out.println("File Created");
    }

    @SneakyThrows
    public void generateAirportReport(Airport airport, ArrayList<Flight> flights){
        String airportReportName = airport.getName() + " report.xlsx";
        Weather weather = new Weather();

        String[] header = new String[]{"Number",
                "Status",
                "Airline",
                "Model",
                "Capacity",
                "Gas Range",
                "Departure City",
                "Arrival City",
                "Departure Country",
                "Arrival Country"};
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i<header.length;i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header[i]);
        }

        int numRow = 1;
        for (Flight flight:flights){
            Row row = sheet.createRow(numRow++);
            row.createCell(0).setCellValue(flight.getNumber());
            row.createCell(1).setCellValue(flight.getStatus());
            row.createCell(2).setCellValue(flight.getAirline());
            row.createCell(3).setCellValue(flight.getAircraft().getAircraftType().getModel());
            row.createCell(4).setCellValue(flight.getAircraft().getAircraftType().getCapacity());
            row.createCell(5).setCellValue(flight.getAircraft().getAircraftType().getGasRange());
            row.createCell(6).setCellValue(flight.getCityOri());
            row.createCell(7).setCellValue(flight.getCityDest());
            row.createCell(8).setCellValue(flight.getCountryOri());
            row.createCell(9).setCellValue(flight.getCountryDest());
        }

        for (int i = 0; i<header.length;i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream file = new FileOutputStream(airportReportName);
        workbook.write(file);
        file.close();
        workbook.close();
        System.out.println("File Created");
        EmailUtils emailUtils = new EmailUtils();
        emailUtils.sendReport(airportReportName);
    }

}
