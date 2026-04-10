public class Feet {
    private final double value;

    public Feet(double value) {
        this.value = value;
    }

    public double toFeet() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof Feet) {
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, value) == 0;
        }

        if (obj instanceof Inches) {
            Inches inches = (Inches) obj;
            return Double.compare(inches.toFeet(), value) == 0;
        }

        return false;
    }
}