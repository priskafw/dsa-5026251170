package lw02.Unguided;
import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<String[]> orders = new LinkedList<>();

        Scanner sc = new Scanner(new File("src/lw02/Unguided/orders.txt"));
        while (sc.hasNextLine()) {
            String baris = sc.nextLine();
            if (!baris.equals("")) {               
                String[] data = baris.split(" ");
                String name = data[0];
                String sideDish = data[1];
                String drink = data[2];
                String tableNumber = data[3];
                orders.add(new String[]{name, sideDish, drink, tableNumber});
            }
        }
        sc.close();

        LinkedList<String[]> foods = new LinkedList<>();
        foods.add(new String[]{"Bakso", "2"});
        foods.add(new String[]{"Sate", "1"});
        foods.add(new String[]{"Soto", "2"});

        LinkedList<String[]> drinks = new LinkedList<>();
        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});

        Queue<String[]> queue = new LinkedList<>(orders);
        LinkedList<String[]> success = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while (!queue.isEmpty()) {
            String[] o = queue.poll();
            String sideDish = o[1];
            String drink = o[2];

            String[] daftarMakanan = null;
            String[] daftarMinuman = null;
            boolean makananTersedia = true;
            boolean minumanTersedia = true;

            for (String[] f : foods) {
                if (f[0].equals(sideDish)) {
                    daftarMakanan = f;
                }
            }
            for (String[] d : drinks) {
                if (d[0].equals(drink)) {
                    daftarMinuman = d;
                }
            }

            if (daftarMakanan != null && Integer.parseInt(daftarMakanan[1]) <= 0) {
                makananTersedia = false;
            }
            if (daftarMinuman != null && Integer.parseInt(daftarMinuman[1]) <= 0) {
                minumanTersedia = false;
            }

            if (makananTersedia && minumanTersedia) {
                if (daftarMakanan != null) {
                    int stok = Integer.parseInt(daftarMakanan[1]);
                    daftarMakanan[1] = "" + (stok - 1);
                }
                if (daftarMinuman != null) {
                    int stok = Integer.parseInt(daftarMinuman[1]);
                    daftarMinuman[1] = "" + (stok - 1);
                }
                success.add(o);
            } else {
                failed.push(o);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : success) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for (String[] f : foods) {
            System.out.println(f[0] + " : " + f[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] d : drinks) {
            System.out.println(d[0] + " : " + d[1]);
        }

        System.out.println();
        System.out.println("=== Failed Orders ===");
        while (!failed.isEmpty()) {
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}