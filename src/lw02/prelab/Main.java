package lw02.prelab;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
 
        LinkedList<String[]> transaksi = new LinkedList<>();
        LinkedList<String[]> customer = new LinkedList<>();
        
        Scanner scanner = new Scanner (Main.class.getResourceAsStream("Transactions.txt"));
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(" ");
            transaksi.add(data);
 
            boolean sudahAda = false;
            for (String[] c : customer) {
                if (c[0].equals(data[0])) {
                    sudahAda = true;
                }
            }
            if (!sudahAda) {
                customer.add(new String[]{data[0], "0"});
            }
        }
        sc.close();
 
        Queue<String[]> antrian = new LinkedList<>(transaksi);
        Stack<String[]> gagal = new Stack<>();
 
        while (!antrian.isEmpty()) {
            String[] t = antrian.poll();
            String nama = t[0];
            String tipe = t[1];
            int jumlah = Integer.parseInt(t[2]);
 
            for (String[] c : customer) {
                if (c[0].equals(nama)) {
                    int saldo = Integer.parseInt(c[1]);
 
                    if (tipe.equals("DEPOSIT")) {
                        saldo = saldo + jumlah;
                        c[1] = "" + saldo;
                    } else {
                        if (jumlah > saldo) {
                            gagal.push(t);
                        } else {
                            saldo = saldo - jumlah;
                            c[1] = "" + saldo;
                        }
                    }
                }
            }
        }
 
        System.out.println("=== Final Balances ===");
        for (String[] c : customer) {
            System.out.println(c[0] + " : " + c[1]);
        }
 
        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!gagal.isEmpty()) {
            String[] t = gagal.pop();
            System.out.println(t[0] + " " + t[1] + " " + t[2]);
        }
    }
}
 