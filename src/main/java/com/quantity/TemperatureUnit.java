package com.quantity;

import com.quantity.common.IMeasurable;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS,
    FAHRENHEIT;

    @Override
    public double toBaseUnit(double value) {
        if (this == CELSIUS) return value;
        return (value - 32) * 5 / 9;
    }

    @Override
    public double fromBaseUnit(double baseValue) {
        if (this == CELSIUS) return baseValue;
        return (baseValue * 9 / 5) + 32;
    }

    // ❌ Temperature doesn't support arithmetic
    @Override
    public boolean supportsArithmetic() {
        return false;
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation
        );
    }
}