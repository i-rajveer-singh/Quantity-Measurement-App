public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.toBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {
        double baseValue = unit.toBaseUnit(value);
        double converted = targetUnit.fromBaseUnit(baseValue);
        return new Quantity<>(converted, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}