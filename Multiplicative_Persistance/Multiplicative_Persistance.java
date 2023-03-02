/*
 * Gives you the numbers with longest multiplicative persistance for their size, under the number inputted
 */
import java.util.*;
public class Multiplicative_Persistance {
    public static long digitalRoot(long n){
        int l = (int)Math.log10(n);
        long result = 1;
        for(int i=0; i<=l; i++){
            result*=n%10;
            n/=10;
        }
        return result;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        sc.close();
        long best = 0;
        int steps = 0;
        for(long i=0; i<a;i++){
            long n = i;
            int count = 0;
            while(n>=10){
                count++;
                n = digitalRoot(n);
            }
            if(count>steps){
                best = i;
                steps = count;
                System.out.println(best+"  |  "+steps);
            }
        }
        System.out.println("The most multiplicately persistant number under "+a+" is "+best+" with a persistance of "+steps);
    }
}
