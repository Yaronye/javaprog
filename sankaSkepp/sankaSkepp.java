package sankaSkepp;
import java.lang.Math;
import java.util.Scanner;


public class sankaSkepp {
    static Scanner scan = new Scanner(System.in);     //DEBUG
    
    public static int[][] createMatrix(int r, int n){
        int board [][] = new int[r][n];
        return board;
    }

    /*public static void valuedMatrix(int r, int n, int board [][]){
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= n; j++){
                board[i][j] = 
            }
        }
    }*/

    public static void main(String[] args) {
        int r = scan.nextInt();
        int n = scan.nextInt();

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= n; j++){
                String x = scan.next();
                if(x = '.'){}

            }
        }

    }
    
}
