package lw01.Unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days) {
        super(id, days, 1); // Assuming 1 unit for CarWash
    }

    @Override
    public int calculateCharge() {
        if (getDays() <= 3) {
            return getDays() * 35000 + 15000;
        }
        return 3 + 25000 + (getDays() - 3 ) * 15000;
    }

    @Override
    public String label() {
        return "Car";
    }
}
