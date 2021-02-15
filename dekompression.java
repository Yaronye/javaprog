import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dekompression{
    static Scanner scan = new Scanner(System.in);
    static String input = scan.next();
    static String[] charList = input.split("");
    static List<String> inputList = new ArrayList<String>(Arrays.asList(charList));
    static int paranthesis = 0;

    public static boolean stringIsInt(String x){        //Checks if the input character is an int. source: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java/5439547#5439547
        try{
            Integer.parseInt(x);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static int doubleInt(String stringInt1, String stringInt2){  //smashes 2 following ints into one int, example 2 followed by 3 will give 23.
        String tempint = "";
        tempint += stringInt1;
        tempint += stringInt2;
        return Integer.parseInt(tempint);
    }

    public static String multiplyString(int x, String y){     //Given a string and an int, the string will be repeated the int nr of times, and made into one string
        String tempString = "";
        for(int i = 0; i < x; i++){
            tempString += y;
        }
        return tempString;
    }

    public static String dekompress(int innerint){
        int tempint = 1;
        String tempstring = "";

        while(inputList.size() != 0){
            if(stringIsInt(inputList.get(0))){              //Check if int
                if(stringIsInt(inputList.get(1))){
                    tempint = doubleInt(inputList.get(0), inputList.get(1));
                    inputList.remove(0);
                }
                else{
                    tempint = Integer.parseInt(inputList.get(0));
                }
            }
            else{                                           //if not int
                if(inputList.get(0).equals("(")){               //if start parantheses
                    paranthesis += 1;
                    inputList.remove(0);
                    tempstring += dekompress(tempint);          //recursion
                    tempint = 1;
                    continue;
                }
                else if(inputList.get(0).equals(")")){          //if end parentheses
                    inputList.remove(0);
                    tempstring = multiplyString(innerint, tempstring);
                    paranthesis -= 1;
                    break;
                }
                else{                                       //if an alphabetical character
                    if(paranthesis > 0){
                        tempstring += multiplyString(tempint, inputList.get(0));
                        tempint = 1;
                    }
                    else{
                        tempstring += multiplyString(tempint, inputList.get(0));
                        tempint = 1;
                    }
                }
            }
            inputList.remove(0);
        }
        return tempstring;
    }

    public static void main(String[] args){
        System.out.println(dekompress(1));
    }    
}
