public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> f1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> i1 = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println(t1.equals(t2)); // true// 1.0 // true (approx)
    }
}