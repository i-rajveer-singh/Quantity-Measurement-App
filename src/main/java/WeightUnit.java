public enum WeightUnit implements IMeasurable {
    KILOGRAM(1),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertToBase(double value) {
        return value * conversionFactor;
    }

    public double convertFromBase(double baseValue) {
        return baseValue / conversionFactor;
    }

    public String getUnitName() {
        return name();
    }
}