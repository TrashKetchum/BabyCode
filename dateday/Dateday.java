/* Code written by Ash in an attempt ot see if I could turn the doomsday algorthym 
(which allows people with only minor mental maths to be able to tell what any given
day of the week a date was) into useful code. I have succeeded in coding it and fun as it is,
useful might be stretching it a little.
*/
import java.util.*;

public class Dateday {

    public static void main(String[] args) {
        while(true){
            int[] arr = {3,28,14,4,9,6,11,8,5,10,7,12};         //doomsday dates
            
            String ans = "";
            boolean leap;
            
            System.out.println("Enter date: (DD/MM/YYYY)");    //parsing user input
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(str.equalsIgnoreCase("esc")) break;
            String [] parts = str.split("/");
            int date = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1])-1;
            int year = Integer.parseInt(parts[2]);
            
            if(year<0) System.out.println("Apologies, this program only excepts AD dates");   //checking year and month validity
            else if(month<0||month>11) System.out.println("Enter Valid Month");
            
            else{
            if(year%4==0 && year%100!=0) leap = true;       //leap year check
            else if(year%400==0) leap = true;
            else leap = false;
            if(leap){
                for(int i=0; i<2; i++) arr[i]+=1;
            }
            
            int doom=year/100;
            int gap=year-(doom*100);               //finding the doomsday for the start of the given century
            switch (doom%4) {
                case 0 -> doom=2;
                case 1 -> doom=0;
                case 2 -> doom=5;
                case 3 -> doom=3;
                default -> {
                }
            }
            
            doom = ((gap+(gap/4)) + doom)%7;    //finding the doomsday of the given year
            gap = date-arr[month];              //taking the gap between the doomsday of the given month and the given date
            doom = (gap + doom)%7;              //this added to the years doomsday modulo 7 will give us a number that corresponds to that dates day of the week
            
            if(doom<0){                         //reversing negatives in mod 7
                doom=doom%7;
                doom+=7;
            }
            
            switch(doom) {                      //assigning the mod 7 numbers to weekdays
                case 0 -> ans = "Sunday";
                case 1 -> ans = "Monday";
                case 2 -> ans = "Tuesday";
                case 3 -> ans = "Wednesday";
                case 4 -> ans = "Thursday";
                case 5 -> ans = "Friday";
                case 6 -> ans = "Saturday";
                default -> {
                }
            }
            System.out.println(date+"/"+(int)(month+1)+"/"+year+" was a "+ans);
        }
        }
    }
}
