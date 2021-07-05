package utils;

import lombok.SneakyThrows;
import model.Flight;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ReportUtil {

    @SneakyThrows
    public void generateReport(Flight flight){
        String flightReportName = "Flight " + flight.getNumber() + "report.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        headerRow = createHeaderRow(headerRow);
        int numRow = 1;
        Row row = sheet.createRow(numRow++);
        row = createRow(row,flight);
        for (int i = 0; i<headerRow.getLastCellNum();i++) {
            sheet.autoSizeColumn(i);
        }
        wirteWorkBook(workbook,flightReportName);
        EmailUtils.sendReport(flightReportName);
    }

    @SneakyThrows
    public void generateDateReport(ArrayList<Flight> flights){
        String flightReportName = "Flights report.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        headerRow = createHeaderRow(headerRow);
        int numRow = 1;
        for (Flight flight:flights){
            Row row = sheet.createRow(numRow++);
            row = createRow(row,flight);
        }
        for (int i = 0; i<headerRow.getLastCellNum();i++) {
            sheet.autoSizeColumn(i);
        }
        wirteWorkBook(workbook,flightReportName);
        EmailUtils.sendReport(flightReportName);
    }

    public static Row createRow(Row row, Flight flight){
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
        return row;
    }

    public static Row createHeaderRow(Row row){
        String[] header = new String[]{"Number","Status","Airline","Model","Capacity","Gas Range","Departure City",
                                        "Arrival City", "Departure Country", "Arrival Country"};
        for (int i = 0; i<header.length;i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(header[i]);
        }
        return row;
    }

    @SneakyThrows
    public static void wirteWorkBook(Workbook workbook, String flightReportName){
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

}
