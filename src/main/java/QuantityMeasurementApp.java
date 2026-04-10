public class QuantityMeasurementApp {
    public static void main(String[] args) {

        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(2.0, LengthUnit.INCH);

        System.out.println(f.add(inch)); // ~1.1666
    }
}