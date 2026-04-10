package com.quantity.service;

import com.quantity.model.QuantityModel;
import com.quantity.common.IMeasurable;
import com.quantity.repository.MeasurementRepository;

public class QuantityMeasurementServiceImpl {

    private final MeasurementRepository repo = new MeasurementRepository();
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

        double resultBase = base1 + base2;

        double result = targetUnit.fromBaseUnit(resultBase);

        // 🔥 NEW LINE (UC16)
        repo.save(result, targetUnit.getUnitName());

        return result;
    }
}
