public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.convertToBase(value);
    }

    public double convertTo(LengthUnit targetUnit) {
        double valueInBase = unit.convertToBase(this.value);
        return targetUnit.convertFromBase(valueInBase);
    }

    //  UC6 method
    public double add(QuantityLength other) {
        double thisInBase = this.unit.convertToBase(this.value);
        double otherInBase = other.unit.convertToBase(other.value);

        return thisInBase + otherInBase;
    }
    //  UC7 method
    public double add(QuantityLength other, LengthUnit targetUnit) {
        double thisInBase = this.unit.convertToBase(this.value);
        double otherInBase = other.unit.convertToBase(other.value);

        double resultInBase = thisInBase + otherInBase;

        return targetUnit.convertFromBase(resultInBase);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;
        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}