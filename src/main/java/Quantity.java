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

    public double convertTo(U targetUnit) {
        double baseValue = this.toBase();
        return targetUnit.fromBaseUnit(baseValue);
    }

    public Quantity<U> add(Quantity<U> other) {
        double sum = this.toBase() + other.toBase();
        double result = unit.fromBaseUnit(sum);
        return new Quantity<>(result, unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        double diff = this.toBase() - other.toBase();
        double result = unit.fromBaseUnit(diff);
        return new Quantity<>(result, unit);
    }

    public double divide(Quantity<U> other) {
        return this.toBase() / other.toBase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}