public class QuantityMeasurementApp {
    public static void main(String[] args) {

        QuantityLength f = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(2.0, LengthUnit.INCH);

        System.out.println(f.add(inch)); // UC6 → ~1.1666
        System.out.println(f.add(inch, LengthUnit.INCH)); // UC7 → 14.0
    }
}