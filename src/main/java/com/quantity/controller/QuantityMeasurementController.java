package com.quantity.controller;

import com.quantity.model.QuantityModel;
import com.quantity.service.QuantityMeasurementServiceImpl;
import com.quantity.LengthUnit;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    private final QuantityMeasurementServiceImpl service = new QuantityMeasurementServiceImpl();

    // 🔥 ADD API
    @PostMapping("/add")
    public double add(@RequestBody QuantityModel request) {

        QuantityModel q1 = new QuantityModel(request.getValue(), LengthUnit.FEET);
        QuantityModel q2 = new QuantityModel(request.getValue(), LengthUnit.INCH);

        return service.add(q1, q2, LengthUnit.FEET);
    }

    // 🔥 COMPARE API
    @PostMapping("/compare")
    public boolean compare(@RequestBody QuantityModel request) {

        QuantityModel q1 = new QuantityModel(1.0, LengthUnit.FEET);
        QuantityModel q2 = new QuantityModel(12.0, LengthUnit.INCH);

        return service.equals(q1, q2);
    }
}