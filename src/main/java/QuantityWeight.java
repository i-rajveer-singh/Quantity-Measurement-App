public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.convertToBase(value);
    }

    public double convertTo(WeightUnit targetUnit) {
        double valueInBase = unit.convertToBase(this.value);
        return targetUnit.convertFromBase(valueInBase);
    }

    public double add(QuantityWeight other) {
        double thisInBase = this.unit.convertToBase(this.value);
        double otherInBase = other.unit.convertToBase(other.value);

        return thisInBase + otherInBase;
    }

    public double add(QuantityWeight other, WeightUnit targetUnit) {
        double thisInBase = this.unit.convertToBase(this.value);
        double otherInBase = other.unit.convertToBase(other.value);

        double resultInBase = thisInBase + otherInBase;

        return targetUnit.convertFromBase(resultInBase);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityWeight)) return false;

        QuantityWeight other = (QuantityWeight) obj;
        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}