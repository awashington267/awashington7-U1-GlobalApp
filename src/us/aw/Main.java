package us.aw;

import java.util.Scanner;

public class Main {

    private static FileInput places = new FileInput("C:\\Users\\Anthony\\Desktop\\2018 School Year\\Spring 2018\\Adv Java\\Unit 1\\Week 3\\Unit Challenge #1\\places.csv");
    private static FileInput stuff = new FileInput("C:\\Users\\Anthony\\Desktop\\2018 School Year\\Spring 2018\\Adv Java\\Unit 1\\Week 3\\Unit Challenge #1\\stuff.csv");
    //private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        Create a report that prints out each country and the number of cities listed in the places file and the number
        of stuff listed in the stuff file.
        For some countries,  the same "stuff" appears more than once for the same country. For example, Argentina has
        two entries for twister.
        Count those instances as 1 "stuff" item for that country.
        That is, count the unique instances of "stuff" as if it was a catalog, not as if it was a warehouse inventory.
         */
        String line = "";
        String[] fields = new String[1];
        findPlaces(fields[0], fields[1]);

        //System.out.format("%8s  %-18s %6s %6s\n","Account","Name", "Movies", "Points");

        while ((line = places.fileReadLine()) != null) {

            while(places.fileReadLine() != null){
               fields = line.split(",");
               places.fileReadLine();
               fields[0] = places.fileReadLine();
               System.out.format("00%6s  %-18s  %2d   %4d\n",fields[0]);

            }

            while(places.fileReadLine() != null){
                fields = line.split(",");
                places.fileReadLine();
                fields[1] = places.fileReadLine();
                System.out.format("00%6s  %-18s  %2d   %4d\n",fields[1]);

            }

            fields = line.split(",");
            findPlaces(fields[0],fields[1]);

//            System.out.format();

        }
        /*
        while ((line = places.fileReadLine()) != null) {
            fields = line.split(",");
            findPurchases(fields[0], nums);
            movieRating(fields[0]);
            System.out.format("00%6s  %-18s  %2d   %4d\n",fields[0],fields[1], nums[0], nums[1], rating[1]);
        }
*/
    }

    public static void findPlaces(String country, String field) {


        int[] num = new int[0];
        num[0] = 0;
        num[1] = 0;
        int[] num1 = new int[0];
        num1[0] = 0;
        num1[1] = 0;
        String line;
        String[] fields;
        boolean done = false;
        while (((line = places.fileReadLine()) != null) && !(done)) {

            fields = line.split(",");
            if (fields[0].compareTo(country) > 0) {
                done = true;

            }
            else if (fields[0].equals(country)) {
                num[0]++;
                num[1] += Integer.parseInt(fields[2]);
            }

            if(fields[1].compareTo(country) > 1){
                done = true;
            }else if(fields[1].equals(country)){
                num1[0]++;
                num1[1] += Integer.parseInt(fields[2]);
            }


        }
    }

    public static void findStuff(String countryStuff, int[] nums) {
        nums[0] = 0;
        nums[1] = 0;
        String line;
        String[] fields;
        boolean done = false;
        while (((line = stuff.fileReadLine()) != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(countryStuff) > 0) {
                done = true;
            }
            else if (fields[0].equals(countryStuff)) {
                nums[0]++;
                nums[1] += Integer.parseInt(fields[2]);
            }

        }
    }


}