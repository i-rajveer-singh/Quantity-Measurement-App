import common.IMeasurable;

public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(0.0328084);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    @Override
    public double toBaseUnit(double value) {
        return value * toFeetFactor;
    }

    @Override
    public double fromBaseUnit(double baseValue) {
        return baseValue / toFeetFactor;
    }
}