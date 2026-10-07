package lw03.prelab;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
public class Main {
    public static void main(String[] args) {
        System.out.println("===== Problem 1 =====");
 
        List<String> playlist = new LinkedList<>();
        Scanner scanner1 = new Scanner(Main.class.getResourceAsStream("playlist.txt")
        );
        while (scanner1.hasNextLine()) {
            String baris = scanner1.nextLine();
            if (baris.startsWith("ADD")) {
                String lagu = baris.substring(4);
                playlist.add(lagu);
            } else if (baris.startsWith("INSERT")) {
                String sisa = baris.substring(7);
                int posisiSpasi = sisa.indexOf(" ");
                String angka = sisa.substring(0, posisiSpasi);
                int index = Integer.parseInt(angka);
                String lagu = sisa.substring(posisiSpasi + 1);
                playlist.add(index, lagu);
            } else if (baris.startsWith("REMOVE")) {
                String lagu = baris.substring(7);
                if (playlist.contains(lagu)) {
                    playlist.remove(lagu);
                }
            }
        }
        scanner1.close();

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            int nomor = i + 1;
            System.out.println(nomor + ": " + playlist.get(i));
        }

        System.out.println();
        System.out.println("===== Problem 2 =====");

        Set<String> peserta = new LinkedHashSet<>();
        int jumlahDuplikat = 0;
        Scanner scanner2 = new Scanner(
            Main.class.getResourceAsStream("participants.txt")
        );
 
        while (scanner2.hasNextLine()) {
            String nama = scanner2.nextLine();
            if (peserta.contains(nama)) {
                jumlahDuplikat++;
            } else {
                peserta.add(nama);
            }
        }
        scanner2.close();

        System.out.println("Unique participants: " + peserta.size());
        int nomorPeserta = 1;
        for (String nama : peserta) {
            System.out.println(nomorPeserta + ". " + nama);
            nomorPeserta++;
        }
        System.out.println("Duplicate registrations: " + jumlahDuplikat);
        System.out.println();
        System.out.println("===== Problem 3 =====");
 
        Map<String, Integer> stok = new LinkedHashMap<>();
 
        int jumlahGagal = 0;
 
        Scanner scanner3 = new Scanner(
            Main.class.getResourceAsStream("inventory.txt")
        );
 
        while (scanner3.hasNext()) {
            String tipe = scanner3.next();
            String produk = scanner3.next();
            int jumlah = scanner3.nextInt();
 
            if (tipe.equals("ADD")) {
                if (stok.containsKey(produk)) {
                    int stokLama = stok.get(produk);
                    stok.put(produk, stokLama + jumlah);
                } else {
                    stok.put(produk, jumlah);
                }
            } else if (tipe.equals("SELL")) {
                if (stok.containsKey(produk)) {
                    int stokLama = stok.get(produk);
                    if (stokLama >= jumlah) {
                        stok.put(produk, stokLama - jumlah);
                    } else {
                        jumlahGagal++;
                    }
                } else {
                    jumlahGagal++;
                }
            }
        }
        scanner3.close();
 
        for (Map.Entry<String, Integer> entry : stok.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + jumlahGagal);
    }
}
 