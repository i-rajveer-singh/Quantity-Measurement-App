public class QuantityMeasurementApp {
    public static void main(String[] args) {

        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(inch.convertTo(LengthUnit.FEET)); // 1.0
    }
}