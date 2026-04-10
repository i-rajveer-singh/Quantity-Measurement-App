package com.quantity;

import com.quantity.common.IMeasurable;

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

    // 🔥 CENTRALIZED ARITHMETIC METHOD
    private Quantity<U> operate(Quantity<U> other, char operation) {

        // 🔥 validate arithmetic support
        unit.validateOperationSupport(String.valueOf(operation));

        double result;

        switch (operation) {
            case '+':
                result = this.toBase() + other.toBase();
                break;
            case '-':
                result = this.toBase() - other.toBase();
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        double finalValue = unit.fromBaseUnit(result);
        return new Quantity<>(finalValue, unit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return operate(other, '+');
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return operate(other, '-');
    }

    public double divide(Quantity<U> other) {
        unit.validateOperationSupport("divide");
        return this.toBase() / other.toBase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        // 🔥 prevent cross-category comparison
        if (this.unit.getClass() != other.unit.getClass()) return false;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}