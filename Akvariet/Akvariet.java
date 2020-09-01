import java.lang.Math;

public class Akvariet{
    public static double distance_calc(double x1, double x2, double y1, double y2, double z1, double z2) {
        double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
        return distance;
    }

    public static void main(String[] arg){
        Kattio io = new Kattio(System.in, System.out);
        double distance_travelled = 0.0;
        double x1, x2, y1, y2, z1, z2;
        int n = io.getInt();
        double[][] coords = new double[n][3];
        double[][] old_coords = new double[n][3];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                coords[i][j] = io.getDouble();
            }
        }
        for(int i = 0; i < n - 1; i++){
            x1 = coords[i][0];
            y1 = coords[i][1];
            z1 = coords[i][2];

            x2 = coords[i + 1][0];
            y2 = coords[i + 1][1];
            z2 = coords[i + 1][2];
            distance_travelled += distance_calc(x1, x2, y1, y2, z1, z2);
        }
        io.printf("%.2f", distance_travelled);
        io.close();
    }
}

