public class ContainedInSquare {
    public static long check(long x, int y){
        for(int i=2;i<=y;i++){
            x*=x;
        }
        return x;
    }
    public static void main(String [] args){
        long [][] arr = new long[100][3];
        int count=0;
        long hold;
        for(int i=2;i<500000;i++){
            for(int j=2; j<3; j++){
                hold = check(i,j);
                if(String.valueOf(hold).contains(String.valueOf(i))){
                    arr[count][0] = i;
                    arr[count][1] = j;
                    arr[count][2] = hold;
                    count++;
                }
            }
        }
        for(int i=0; i<50;i++){
            if(arr[i][0]==0) break;
            else System.out.println(arr[i][0]+"   |   "+arr[i][1]+"   |   "+arr[i][2]);
        }
    }
}
