package lw03.Unguided;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Main {
    public static void main(String[] args) {
        Set<String> registered = new HashSet<>();
        Set<String> checkedIn = new HashSet<>();
        int rejected = 0;
 
       
        Scanner scanner1 = new Scanner(
            Main.class.getResourceAsStream("registrations.txt")
        );
        while (scanner1.hasNext()) {
            String id = scanner1.next();
            registered.add(id);
        }
        scanner1.close();
 
        System.out.println("===== Event Check-In Results =====");

        Scanner scanner2 = new Scanner(
            Main.class.getResourceAsStream("checkins.txt")
        );
        while (scanner2.hasNext()) {
            String id = scanner2.next();
            if (!registered.contains(id)) {
                System.out.println(id + ": Rejected (not registered)");
                rejected++;
            } else if (checkedIn.contains(id)) {
                System.out.println(id + ": Rejected (already checked in)");
                rejected++;
            } else {
                System.out.println(id + ": Checked in");
                checkedIn.add(id);
            }
        }
        scanner2.close();
 
        int absent = registered.size() - checkedIn.size();
 
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered.size());
        System.out.println("Successful check-ins: " + checkedIn.size());
        System.out.println("Absent students: " + absent);
        System.out.println("Rejected attempts: " + rejected);
    }
}
 