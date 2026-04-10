package service;

import model.QuantityModel;
import common.IMeasurable;

public class QuantityMeasurementServiceImpl {

    public <U extends IMeasurable> boolean compare(QuantityModel<U> q1, QuantityModel<U> q2) {
        double base1 = q1.getUnit().toBaseUnit(q1.getValue());
        double base2 = q2.getUnit().toBaseUnit(q2.getValue());
        return Double.compare(base1, base2) == 0;
    }

    public <U extends IMeasurable> double convert(QuantityModel<U> q, U targetUnit) {
        double base = q.getUnit().toBaseUnit(q.getValue());
        return targetUnit.fromBaseUnit(base);
    }

    public <U extends IMeasurable> double add(QuantityModel<U> q1, QuantityModel<U> q2, U targetUnit) {
        double base1 = q1.getUnit().toBaseUnit(q1.getValue());
        double base2 = q2.getUnit().toBaseUnit(q2.getValue());
        double result = base1 + base2;
        return targetUnit.fromBaseUnit(result);
    }
}