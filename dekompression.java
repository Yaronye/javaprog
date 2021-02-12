
//package dekompression;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class dekompression{
    static Scanner scan = new Scanner(System.in);     //DEBUG
    static String input = scan.next();
    static String[] charList = input.split("");
    static List<String> inputList = new ArrayList<String>(Arrays.asList(charList));
    static String addString = "";
    static boolean paranthesis = false;
    //static int tempint = 1;
    //static String tempstring = "";

    public static boolean stringIsInt(String x){
        try{
            Integer.parseInt(x);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static int doubleInt(String stringInt1, String stringInt2){
        String tempint = "";
        tempint += stringInt1;
        tempint += stringInt2;
        return Integer.parseInt(tempint); //add a return for i?
    }

    public static void multiplyString(int x, String y){
        System.out.println("MULTIPLY STRING"); 
        String multiString = "";
        for(int i = 0; i < x; i++){
            multiString += y;
        }
        addString += multiString;
    }

    public static void removeFromList(List<String> list){
        list.remove(0);
    }

    public static void dekompress(int tempint, String tempstring){
        
        
        //for(int i = 0; i < inputList.length; i++){
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
                if(inputList.get(0).equals("(")){          //if start parantheses
                    paranthesis = true;
                    inputList.remove(0);
                    dekompress(tempint, tempstring);      //recursion
                    continue;
                }
                else if(inputList.get(0).equals(")")){      //if end parentheses
                    inputList.remove(0);
                    multiplyString(tempint, tempstring);
                    paranthesis = false;
                    tempint = 1;
                    tempstring = "";
                    break;
                }
                else{                                       //if an alphabetical character
                    if(paranthesis){
                        tempstring += inputList.get(0);
                    }
                    else{
                        multiplyString(tempint, inputList.get(0));
                        tempint = 1;
                    }
                }
            }
            //System.out.println("inputList");
            //System.out.println(inputList.get(0));
            inputList.remove(0);
        }
        System.out.println("HELLO");
        System.out.println(tempint);
        System.out.println("HELLO2");
        System.out.println(tempstring);
         //add string here
    }

    public static void main(String[] args){
        dekompress(1, "");
        System.out.println(addString);
    }    
}
