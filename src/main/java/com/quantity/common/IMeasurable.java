package com.quantity.common;

public interface IMeasurable {
    double toBaseUnit(double value);
    double fromBaseUnit(double baseValue);

    default String getUnitName() {
        return this.toString();
    }

    default boolean supportsArithmetic() {
        return true;
    }

    default void validateOperationSupport(String operation) {
    }
}
