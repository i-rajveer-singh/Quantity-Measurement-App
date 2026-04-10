public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Feet f = new Feet(1.0);
        Inches i = new Inches(12.0);

        System.out.println(f.equals(i)); // true
    }
}