/*
 * Allows users to encode or decode text using Caesar, Atbash, A1Z26 and Vigineres.
 */
import java.util.Scanner;
public class Cyphers {
    public static String a1z26(String s){
        String [] split = s.split("-");
        String out = "";
        for(int i = 0; i<split.length; i++){
            out += (char)((Integer.parseInt(split[i])+96));
        }
        return out;
    }
    public static String reva1z26(String s){
        String out = "";
        for(int i = 0; i<s.length(); i++){
            if(s.substring(i,i+1).matches("[a-z]")){
                out+= (int) s.charAt(i)-96;
                out+= "-";
            }
            else out+=s.charAt(i);
        }
        return out;
    }
    public static String atbash(String s){
        String out = "";
        for(int i = 0; i<s.length(); i++){
            if(s.substring(i,i+1).matches("[a-z]")){
            out += (char) ((122-((int)s.charAt(i)))+97);
            }
            else out+=s.charAt(i);
        }
        return out;
    }
    public static String caesar(String s, int n){
        int a;
        for(int i = 0; i<s.length(); i++){
            a = ((int)s.charAt(i))-n;
            if(a<97) a+=26;
            if(a>122) a-=26;
            if(s.substring(i,i+1).matches("[a-z]")){
                s = s.substring(0,i)+(char)a+s.substring(i+1);
            }
        }
        return s;
    }
    public static String revcaesar(String s, int n){
        int a;
        for(int i = 0; i<s.length(); i++){
            a = ((int)s.charAt(i))+(n%26);
            if(a<97) a+=26;
            if(a>122) a-=26;
            if(s.substring(i,i+1).matches("[a-z]")){
                s = s.substring(0,i)+(char)a+s.substring(i+1);
            }
        }
        return s;
    }
    public static String vig(String a, String b){
        int count = 0;
        int n;
        for(int i = 0; i<a.length(); i++){
            if(count>b.length()-1) count=0;
            n = (int)a.charAt(i) - (int)b.charAt(count);
            if(n<0) n+=26;
            n+=97;
            if(a.substring(i,i+1).matches("[a-z]")){
                a = a.substring(0,i)+(char)n+a.substring(i+1);
                count++;
            }
        }
        return a;
    }
    public static String revvig(String a, String b){
        int count = 0;
        int n;
        for(int i = 0; i<a.length(); i++){
            if(count>b.length()-1) count=0;
            n = ((int)a.charAt(i)-97) + ((int)b.charAt(count)-97);
            if(n>25) n-=26;
            n+=97;
            if(a.substring(i,i+1).matches("[a-z]")){
                a = a.substring(0,i)+(char)n+a.substring(i+1);
                count++;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Cypher Type:");
            String strin = sc.nextLine();
            if(strin.equalsIgnoreCase("exit")){
                break;
            }
            if(strin.equalsIgnoreCase("rev")){
                System.out.println("Enter Cypher Type:");
                strin = sc.nextLine();
                if(strin.equalsIgnoreCase("vig")){
                    System.out.println("Enter Text, then enter key:");
                    System.out.println(revvig(sc.nextLine().toLowerCase(),sc.nextLine().toLowerCase()));
                }
                if(strin.equalsIgnoreCase("atbash")){
                    System.out.println("Enter Text:");
                    System.out.println(atbash(sc.nextLine().toLowerCase()));
                }
                if(strin.equalsIgnoreCase("A1Z26")){
                    System.out.println("Enter Text:");
                    System.out.println(reva1z26(sc.nextLine().toLowerCase()));
                }
                if(strin.equalsIgnoreCase("caesar")){
                    System.out.println("Enter Text, then enter shift:");
                    System.out.println(revcaesar(sc.nextLine().toLowerCase(),Integer.parseInt(sc.nextLine())));
                }
                strin = "";
            }
            if(strin.equalsIgnoreCase("atbash")){
                System.out.println("Enter Cypher:");
                System.out.println(atbash(sc.nextLine().toLowerCase()));
            }
            if(strin.equalsIgnoreCase("A1Z26")){
                System.out.println("Enter Cypher:");
                System.out.println(a1z26(sc.nextLine().toLowerCase()));
            }
            if(strin.equalsIgnoreCase("Caesar")){
                System.out.println("Enter Cypher, then enter the shift");
                System.out.println(caesar(sc.nextLine().toLowerCase(),Integer.parseInt(sc.nextLine())));
            }
            if(strin.equalsIgnoreCase("vig")){
                System.out.println("Enter Cypher");
                System.out.println(vig(sc.nextLine().toLowerCase(),sc.nextLine().toLowerCase()));
            }
        }
    }
}
