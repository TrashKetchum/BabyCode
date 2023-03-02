/*
 * Returns all mersenne primes under 32bits
 */
public class Mersenne_prime_check {
    public static boolean isPrime(long n){
        if(n%2==0||n%3==0||n%5==0){
            return false;
        }
        for(long i=6; i<n/2; i+=6){
            if(n%(i-1)==0||n%(i+1)==0) return false;
        }
        return true;
    }
    public static boolean checkLucas(long n, long m){
        long count = 4;
        for(long i=0; i<n-2; i++){
            count = ((count*count)-2)%m;
        }
        return 0==count;
    }
    public static void main(String[] args) {
        int [] pArr = new int[50];
        long[] mArr = new long[8];
        pArr[0]=2; pArr[1]=3; pArr[2]=5; mArr[0]=3;
        long c = 0;
        int j = 3;
        int y = 1;
        for(int i=6; i<65; i+=6){
            if(isPrime(i-1)) {
                pArr[j]=(i-1);
                j++;
            }
            if(isPrime(i+1)) {
                pArr[j]=i+1;
                j++;
            }
        }
        for(int i=0; i<pArr.length; i++){
            c = Math.round(Math.pow(2, pArr[i]))-1;
            if(checkLucas(pArr[i], c)){
                mArr[y] = c;
                y++;
            }
        }
        for(int i = 0; i < mArr.length; i++) System.out.println(mArr[i]);
    }
}
