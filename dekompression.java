//package dekompression;
import java.util.Scanner;

public class dekompression {
    static Scanner scan = new Scanner(System.in);     //DEBUG

    public static boolean stringIsInt(String x){
        try{
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static int whileInt(String[] inputList, int i){
        String tempint = "";

        while(stringIsInt(inputList[i])){
            tempint += inputList[i];
            i++;
        }
        return Integer.parseInt(tempint);
    }

    public static String parentheses(String[] inputList){
        String tempString = "";
        int i = 0;

        while(inputList[i] != ")"){
            if(inputList[i] != "("){
                tempString += inputList[i];
            }
            else{
                parentheses(inputList); 
            }
            i++;
        }
        return tempString;
    }


    public static void main(String[] args){
        String input = scan.next();
        String[] inputList = input.split("");
        
        for(int i = 0; i < inputList.length; i++){
            int tempint = 0;
            if(stringIsInt(inputList[i])){              //Check if int
                tempint = whileInt(inputList, i);
            }
            else{
                if(inputList[i].equals("(")){
                    
                    }
                }
            }
            
        }

    }

    
}