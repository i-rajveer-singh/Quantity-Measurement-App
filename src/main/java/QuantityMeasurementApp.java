public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<VolumeUnit> l1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> ml = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(0.264172, VolumeUnit.GALLON);

        System.out.println(l1.equals(ml));      // true
        System.out.println(l1.equals(gallon));  // true (approx)
    }
}