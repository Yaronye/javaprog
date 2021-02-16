package temperaturstatistik;
import java.util.*;

public class Temperaturstatistik{
    static Scanner scan = new Scanner(System.in);
    static int a;
    static int b;
    static String[] timestamp;
    static ArrayList<City> cities;
    
    public static void readInfo(){
        scan.useLocale(Locale.US);
        a = scan.nextInt();
        b = scan.nextInt();
        timestamp = new String[a];
        cities = new ArrayList<>();

        for(int i = 0; i < a; i++){
            timestamp[i] = scan.next();
        }
        
        for(int i = 0; i < b; i++){
            double[] temptemp = new double[a];
            String tempname = scan.next();
            
            for(int j = 0; j < a; j++){
                temptemp[j] = scan.nextDouble();
            }
            cities.add(new City(tempname, temptemp));
        }
    }

    public static int findSortIndex(){        //iterator to find the index of the sort date
        String stringKey = scan.next();
        int index = 0;
        for(int i = 0; i < a; i++){
            if(timestamp[i].equals(stringKey)){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        String printString = "";
        readInfo();
        int index = findSortIndex();
        cities.get(0).setIndex(index);        //changes index for all cities by changing one of them (static)
        Collections.sort(cities);
        for(int i = 0; i < b; i++){
            City tempCity = cities.get(i);
            printString += tempCity.name;
            printString += " ";
            printString += tempCity.temperature[index];
            printString += "\n";
        }
        System.out.println(printString);
    }    
}
