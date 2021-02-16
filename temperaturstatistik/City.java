package temperaturstatistik;

public class City implements Comparable<City>{
    String name;
    double[] temperature;      //a styckna temperatures
    static int index = 0;

    City(String cname, double[] temp){
        name = cname;
        temperature = temp;
    }
    
    @Override
    public int compareTo(City place){
        int tempint = Double.compare(this.temperature[index], place.temperature[index]);
        if(tempint == 0){
            tempint = this.name.compareTo(place.name);
        }
        return tempint;
    }

    public void setIndex(int x){
        index = x;
    }    
}
