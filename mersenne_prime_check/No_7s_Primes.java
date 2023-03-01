import java.util.*;
public class No_7s_Primes {
    public static boolean isPrime(long n){
        if(n%2==0||n%3==0||n%5==0){
            return false;
        }
        for(long i=6; i<n/2; i+=6){
            if(n%(i-1)==0||n%(i+1)==0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] pn1 = new int[n/2];
        pn1[0] = 2; pn1[1]=3;
        int count=2;
        for(int i=6; i<n; i+=6){
            if(isPrime(i-1)){
                pn1[count]=i-1;
                count++;
            }
            if(isPrime(i+1)){
                pn1[count]=i+1;
                count++;
            }
        }
        int[] p1 = new int[count];
        int[] pn2 = new int[count];
        int count2= 0;
        for(int i = 0; i<count; i++){
            p1[i]=pn1[i];
        }
        for(int i = 0; i<p1.length; i++){
            if(!String.valueOf(p1[i]).contains("7")){
                pn2[count2]=i;
                count2++;
            }
        }
        int[] p2 = new int[count2];
        for(int i = 0; i<count2; i++){
            p2[i]=pn2[i];
        }
        double lp = p1.length;
        double l7 = p2.length;
        System.out.println("The largest prime under "+n+" with no digits = 7 is "+p2[p2.length-1]);
        System.out.println("The ratio, under "+n+", of the non-seven set to the set of primes is "+(lp/l7));
    }
            
}
