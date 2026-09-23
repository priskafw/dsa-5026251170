package lw01.Unguided;

public abstract class WashService implements Billable {
    private String id;
    private int days;
    private int units;

    protected WashService(String id, int days, int units) {
        if (days <= 0) {
            throw new IllegalArgumentException("Jumlah hari harus lebih dari 0");
        }
        if (units <= 0) {
            throw new IllegalArgumentException("Jumlah unit harus lebih dari 0");
        }
        this.id = id;
        this.days = days;
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public int getUnits() {
        return units;
    }

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Jumlah unit harus lebih dari 0");
        }
        return calculateCharge() * units;
    }
    public String label() {
        return "Wash Service";
    }
    public String summary() {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}
