package lw04.Unguided;
import java.util.Scanner;

public class Main {
    public static void bubbleSort (int[] A, int awal, int akhir){
        int n = A.length;
        for (int i = awal; i< akhir; i++){
            for (int j = 0; j<= n-2-i; j++){
                if (A[j] < A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
    }
    
    public static void binarySearch(int[] A, int target, int[] hasil) {
        int low = 0;
        int high = A.length - 1;
        int langkah = 0;
 
        while (low <= high) {
            int mid = (low + high) / 2;
            langkah++;
 
            if (A[mid] == target) {
                hasil[0] = mid;
                hasil[1] = langkah;
                return;
            } else if (A[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
 
        hasil[0] = -1;
        hasil[1] = langkah;
    }

    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            if (i < A.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("parcels.txt"));
        int n = scanner.nextInt();
        int[] parcels = new int[n];
        for (int i = 0; i < n; i++) {
            parcels[i] = scanner.nextInt();
        }
 
        int m = scanner.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = scanner.nextInt();
        }
        scanner.close();

        bubbleSort(parcels, 0, 2);
        int[] saatBateraiHabis = new int[n];
        for (int i = 0; i < n; i++) {
            saatBateraiHabis[i] = parcels[i];
        }

        bubbleSort(parcels, 2, n - 1);
 
        System.out.println("==== After 2 Passes ====");
        printArray(saatBateraiHabis);
        System.out.println();
 
        System.out.println("==== Fully Sorted ====");
        printArray(parcels);
        System.out.println();
 
        System.out.println("==== Search Results ====");
        int[] hasil = new int[2];
        for (int i = 0; i < m; i++) {
            binarySearch(parcels, targets[i], hasil);
            if (hasil[0] != -1) {
                System.out.println(targets[i] + ": FOUND at index " + hasil[0] + " (steps: " + hasil[1] + ")");
            } else {
                System.out.println(targets[i] + ": NOT FOUND (steps: " + hasil[1] + ")");
            }
        }
    }
}
