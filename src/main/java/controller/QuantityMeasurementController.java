package controller;

import common.IMeasurable;
import model.QuantityModel;
import service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementController {

    private final QuantityMeasurementServiceImpl service;


    public QuantityMeasurementController() {
        this.service = new QuantityMeasurementServiceImpl();
    }

    public <U extends IMeasurable> boolean compare(QuantityModel<U> q1, QuantityModel<U> q2) {
        return service.compare(q1, q2);
    }

    public <U extends IMeasurable> double convert(QuantityModel<U> q, U targetUnit) {
        return service.convert(q, targetUnit);
    }

    public <U extends IMeasurable> double add(QuantityModel<U> q1, QuantityModel<U> q2, U targetUnit) {
        return service.add(q1, q2, targetUnit);
    }
}