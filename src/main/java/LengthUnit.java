public enum LengthUnit {
    FEET(1),
    INCH(1.0 / 12),
    YARD(3),
    CENTIMETER(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertToBase(double value) {
        return value * conversionFactor;
    }

    public double convertFromBase(double baseValue) {
        return baseValue / conversionFactor;
    }
}