class QuantityMeasurementApp {
    public static void main(String[] args) {

        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(kg.equals(g)); // true
        System.out.println(kg.add(g, WeightUnit.KILOGRAM)); // 2.0
    }
}