public class QuantityMeasurementApp {
    public static void main(String[] args) {
        QuantityLength q1 = new QuantityLength(1.0, "FEET");
        QuantityLength q2 = new QuantityLength(12.0, "INCH");

        System.out.println(q1.equals(q2)); // true
    }
}