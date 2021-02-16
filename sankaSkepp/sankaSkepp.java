package sankaSkepp;
import java.util.Scanner;


public class SankaSkepp 
{
    static Scanner scan = new Scanner(System.in);     //DEBUG
    static int shipCount = 0;
    static String[][] board;
    static String[][] visitedMatrix;
    public static void main(String[] args)
    {
        int r = scan.nextInt();
        int n = scan.nextInt();
        board = new String[r][n];
        visitedMatrix  = new String[r][n];

        valuedMatrix(r, n);
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j].equals("O"))
                {
                    if(visitedMatrix[i][j] == null || visitedMatrix[i][j].isEmpty())
                    {
                        shipCount += 1;
                        if(j + 1 < n)
                        {
                            if(board[i][j + 1].equals("O"))
                            {
                                //sideways ship
                                horizontalShip(r, n, i, j);
                                continue;
                            }
                        }
                        //downward ship
                        verticalShip(r, n, i, j);
                    }
                }
            }
        }
        System.out.println(shipCount);
    }

    public static void valuedMatrix(int r, int n)
    {
        for(int i = 0; i < r; i++)
        {
            String line = scan.next();
            String[] lineChars = line.split("");
            
            
            for(int j = 0; j < n; j++)
            {
                board[i][j] = lineChars[j];
            }
        }
    }

    public static void horizontalShip(int r, int n, int i, int j)
    {
        while(j < n)
        {
            if(board[i][j].equals("O"))
            {
                visitedMatrix[i][j] = "ship";
                j += 1;
            }
            else{
                break;
            }
            
        }
    }

    public static void verticalShip(int r, int n, int i, int j)
    {
        while(i < r)
        {
            if(board[i][j].equals("O"))
            {
                visitedMatrix[i][j] = "ship";
                i += 1;
            }
            else
            {
                break;
            }
        }
    } 
}
