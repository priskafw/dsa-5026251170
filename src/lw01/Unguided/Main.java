package lw01.Unguided;
import java.util.Scanner;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<WashService> WashServices = new ArrayList<>();
            InputStream inputFile = Main.class.getResourceAsStream("/lw01/Unguided/washes.txt");
            Scanner fileScanner = new Scanner(inputFile);
            int n = fileScanner.nextInt(); 
            for (int i = 0; i < n; i++) {
                String type = fileScanner.next();
                String id = fileScanner.next();
                int days = fileScanner.nextInt();

                if (type.equals("CAR")) {
                    WashServices.add(new CarWash(id, days));
                } else if (type.equals("MOTORCYCLE")) {
                    WashServices.add(new MotorcycleWash(id, days));
                }
            }
            fileScanner.close();
        }
    }



