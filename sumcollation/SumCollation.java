public class SumCollation {
    public static float Sum(float a, float b){
        return (((b-a)+1)/2)*(a+b);
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            for(int j=i+1; j<100; j++){
                   float a = Sum(i,j);
                   //System.out.println(i+"|"+j+"|"+a);
                   if(a==(i*100)+j) System.out.println(i+" to "+j+" = "+(int)a);
            }
        }
        System.out.println("Done");
    }
}
