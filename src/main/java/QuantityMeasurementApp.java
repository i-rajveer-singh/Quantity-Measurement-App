public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> f1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> i1 = new Quantity<>(12.0, LengthUnit.INCH);

        Quantity<LengthUnit> resultAdd = f1.add(i1);
        System.out.println(resultAdd.convertTo(LengthUnit.FEET)); // 2.0

        Quantity<LengthUnit> resultSub = f1.subtract(i1);
        System.out.println(resultSub.convertTo(LengthUnit.FEET)); // 0.0

        System.out.println(f1.divide(i1)); // 1.0 // true (approx)
    }
}