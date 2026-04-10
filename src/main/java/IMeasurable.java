public interface IMeasurable {

    double toBaseUnit(double value);
    double fromBaseUnit(double baseValue);

    // 🔥 NEW (default allows arithmetic)
    default boolean supportsArithmetic() {
        return true;
    }

    // 🔥 NEW (validation hook)
    default void validateOperationSupport(String operation) {
        // default → do nothing
    }
}