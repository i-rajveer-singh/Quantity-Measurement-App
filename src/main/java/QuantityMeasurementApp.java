import controller.QuantityMeasurementController;
import model.QuantityModel;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementController controller = new QuantityMeasurementController();

        QuantityModel<LengthUnit> f = new QuantityModel<>(1.0, LengthUnit.FEET);
        QuantityModel<LengthUnit> inch = new QuantityModel<>(12.0, LengthUnit.INCH);

        System.out.println(controller.compare(f, inch)); // true

        double result = controller.add(f, inch, LengthUnit.FEET);
        System.out.println(result); // 2.0
    }
}