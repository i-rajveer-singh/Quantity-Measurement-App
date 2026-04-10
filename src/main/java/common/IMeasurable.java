package common;

public interface IMeasurable {
    double toBaseUnit(double value);
    double fromBaseUnit(double baseValue);

    default boolean supportsArithmetic() {
        return true;
    }

    default void validateOperationSupport(String operation) {
    }
}