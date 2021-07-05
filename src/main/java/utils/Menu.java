package utils;


public class Menu {
    public static void showMainMenu(){
        System.out.println("--------Select an Option------------");
        System.out.println("1 List Flights");
        System.out.println("2 Add Flight");
        System.out.println("3 Add from File");
        System.out.println("4 Update Flight");
        System.out.println("5 Generate report by date");
        System.out.println("6 Generate Flight Report");
        System.out.println("7 Exit");
        System.out.println("-------------------------------------");
    }

    public static void setStatus(){
        System.out.println("-----------Status Options----------------");
        System.out.println("1 Set Status as Ontime");
        System.out.println("2 Set Status as Delayed");
        System.out.println("3 Set Status as Cancelled");
        System.out.println("4 Set Status as Landed");
        System.out.println("____________________________________________");
    }
}
