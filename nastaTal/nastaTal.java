package nastaTal;
import java.util.Scanner;             //DEBUG

public class nastaTal {
    static Scanner scan = new Scanner(System.in);     //DEBUG

    public static int formula(int a, int b, int c){
        return ((a * b) + c);
    }
    
    public static int[] findBandC(int[] intList, int n){
        int a;
        int[] BandC = new int[2];
        boolean found = false;
        //a1 = a*b+c    --FORMULA
        for(int b = -9; b <=9; b++){
            for(int c = -9; c <=9; c++){
                for (int i = 0; i < n - 1; i++) {
                    a = formula(intList[i], b, c);
                    if(a == intList[i + 1]){
                        found = true;
                    }
                    else{
                        found = false;
                        break;
                    }
                }
                if(found){
                    BandC[0] = b;
                    BandC[1] = c;
                    return BandC;
                }
            }
        }
        return null;
    }



    public static void main(String[] args) {
        //Kattio io = new Kattio(System.in, System.out);   //KATTIS
        //int n = io.getInt();     //KATTIS
        int n = scan.nextInt();   //DEBUG
        int[] intList = new int[n]; 

        //create a list with all ints of the talföljd
        for(int i = 0; i < n; i++){ 
            intList[i] = scan.nextInt();          //DEBUG
            //intList[i] = io.getInt();             //KATTIO
        }
        
        int[] BandC = findBandC(intList, n);

        if (BandC != null){
            int a1 = formula(intList[n-1], BandC[0], BandC[1]);
            System.out.println(a1);
        }
        else{
            System.out.println("no");
        }
    }
    
}