
public class Inches {
    private final double value;

    public Inches(double value) {
        this.value = value;
    }

    public double toFeet() {
        return value / 12;
    }
}