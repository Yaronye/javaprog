import java.util.Scanner;

public class laggIhopOrd{
    static Scanner scan = new Scanner(System.in);     //DEBUG

    public static String stringAdd(String x, String y) {
        //System.out.println(x);
        //System.out.println(y);
        x = x+y;
        //System.out.println(x);
        return x;
    }

    public static void main(String[] args) {
         //Kattio io = new Kattio(System.in, System.out);   //KATTIS
         //int n = io.getInt();     //KATTIS
        int n = scan.nextInt();   //DEBUG
        StringBuilder finalword = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String nextWord = scan.next();  //DEBUG
            System.out.println(nextWord);     //DEBUG
            //String nextWord = io.getWord();     //KATTIS
            finalword.append(nextWord);
        }
        //io.printf(finalword); //KATTIS
        //io.close();   //KATTIS
        System.out.println(finalword);
    }
}