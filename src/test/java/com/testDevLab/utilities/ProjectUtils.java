package com.testDevLab.utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


public class ProjectUtils {

    /**
     * Performs an active pause
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * paring the arrivalDate which is given date format ("dd-MMM-yy")
     */
    public static int [] integerParsingDate( String expectedDate) throws ParseException {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("dd-MMM-yy").parse(expectedDate));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        System.out.println(sdf.format(cal.getTime()));
        String ArrivalDate=sdf.format(cal.getTime());

        String[] part = ArrivalDate.split("-");
        int dateLenght= part.length;
        int[] dateExpected= new int[dateLenght];

        for(int i=0; i<dateLenght;i++){
            int dateSplit = Integer.parseInt(part[i]);
            dateExpected[i]=dateSplit;

        }
        System.out.println("date = " + Arrays.toString(dateExpected));
        return dateExpected;


    }

    /**
     * the given date format ("dd-MMM-yy") convertion ("dd-MM-yy")
     */
    public static int [] integerParsingDate() throws ParseException {


        Format formatter = new SimpleDateFormat("dd-MMM-yy");
        String todayDate = formatter.format(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("dd-MMM-yy").parse(todayDate));
        SimpleDateFormat todayDateFormat = new SimpleDateFormat("dd-MM-yy");
        System.out.println(todayDateFormat.format(cal.getTime()));
        String todayDateFormatStr=todayDateFormat.format(cal.getTime());

        String[] part = todayDateFormatStr.split("-");
        int dateLenght= part.length;
        int[] dateToday= new int[dateLenght];

        for(int i=0; i<dateLenght;i++){
            int dateSplit = Integer.parseInt(part[i]);
            dateToday[i]=dateSplit;

        }
        System.out.println("dateToday = " + Arrays.toString(dateToday));
        return dateToday;

    }

    /**
     * the right arrow clicking number calculation
     */
    public static int cancellationCal(int []dateExpected, int [] dateToday){
        System.out.println("dateExpected = " + Arrays.toString(dateExpected));
        System.out.println("dateToday = " + Arrays.toString(dateToday));
        int totalMonthClicking=0;
        if (dateExpected[2]-dateToday[2]>2){
            int yearMonths=(dateExpected[2]-dateToday[2]-1)*12;
            int monthInDateExpected=dateExpected[1];
            int monthInDateToday=12-dateToday[1];
            totalMonthClicking=yearMonths+monthInDateExpected+monthInDateToday;
        }else if (dateExpected[2]-dateToday[2]==1){
            int monthInDateExpected=dateExpected[1];
            int monthInDateToday=12-dateToday[1];
            totalMonthClicking=monthInDateExpected+monthInDateToday;
        }else if (dateExpected[2]-dateToday[2]==0){
            int monthInDateToday=dateExpected[1]-dateToday[1];
            totalMonthClicking=monthInDateToday;
        }
        System.out.println("totalMonthClicking = " + totalMonthClicking);
        return totalMonthClicking;


    }
    /**
     * date format(dd-MMM-yy) converting (dd-MM-yyyy)
     */

    public static String integerParsingDate1(String expectedDate) throws ParseException {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new SimpleDateFormat("dd-MMM-yy").parse(expectedDate));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        System.out.println(sdf.format(cal.getTime()));
        String ArrivalDate=sdf.format(cal.getTime());

        String[] part = ArrivalDate.split("-");
        int dateLenght= part.length;
        int[] dateExpected= new int[dateLenght];
        String y="";
        for(int i=0; i<dateLenght;i++){
            if(i==2){
                int dateSplit = Integer.parseInt(part[i]);
                int year=2000+dateSplit;
                dateExpected[i]=year;
                y=y+String.valueOf(year);
            }else {
                int dateSplit = Integer.parseInt(part[i]);
                dateExpected[i] = dateSplit;
                y=y+String.valueOf(dateSplit);

            }

        }

        return y;

    }

    /**
    *store the info to .CSV file
     */
    public static void writeToCSVFile(String fileName, ArrayList<String> variableYouWantToUse) {
        try(PrintWriter pw=new PrintWriter(fileName)) {

            pw.write(String.valueOf(variableYouWantToUse));

        } catch (FileNotFoundException e) {
            System.out.println("Error creating/writing to file");
            e.printStackTrace();
        }

    }


}