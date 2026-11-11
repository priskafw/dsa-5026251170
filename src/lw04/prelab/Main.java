package lw04.prelab;
import java.util.Scanner;

public class Main {
            public static void insertionSort (int [] arr, int passes){
            for (int i = 1; i <= passes && i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] < key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }

        public static int sequentialSearch (int [] arr, int target){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        
        public static void main (String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = scanner.nextInt();
        int [] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int [] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = scanner.nextInt();
        }
        scanner.close();

        insertionSort(branches, 3);
        for (int i=0; i<n; i++){
            System.out.print(branches[i]);
            if (i < n-1){
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i=0; i<m; i++){
            int index = sequentialSearch(branches, targets[i]);
            if (index != -1){
                System.out.println(targets[i] + " FOUND at index " + index);
            } else {
                System.out.println(targets[i] + " NOT FOUND");
            }

        }
            
    }
    
}
