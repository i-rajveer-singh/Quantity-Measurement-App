public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBase() {
        return unit.convertToBase(value);
    }

    public Quantity<U> convertTo(U targetUnit) {
        double baseValue = unit.convertToBase(this.value);
        double converted = targetUnit.convertFromBase(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        double sumBase = this.toBase() + other.toBase();
        double result = this.unit.convertFromBase(sumBase);

        return new Quantity<>(result, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sumBase = this.toBase() + other.toBase();
        double result = targetUnit.convertFromBase(sumBase);

        return new Quantity<>(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity<?> other = (Quantity<?>) obj;

        if (this.unit.getClass() != other.unit.getClass()) return false;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}