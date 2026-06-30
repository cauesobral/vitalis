package com.cauesobral.vitalis.service;

import com.cauesobral.vitalis.model.Priority;
import com.cauesobral.vitalis.model.Triage;
import org.springframework.stereotype.Service;

@Service
public class PriorityCalculatorService {

    public Priority calculate(Triage triage) {

        Integer hr = triage.getHeartRate();
        Double temp = triage.getTemperature();
        Integer sys = triage.getSystolicPressure();
        Integer dia = triage.getDiastolicPressure();
        Integer spo2 = triage.getOxygenSaturation();

        if (isRed(hr, temp, sys, spo2)) {
            return Priority.RED;
        }

        if (isOrange(hr, temp, sys, spo2)) {
            return Priority.ORANGE;
        }

        if (isYellow(hr, temp, sys, dia)) {
            return Priority.YELLOW;
        }

        if (hasAnyVitalSign(hr, temp, sys, dia, spo2)) {
            return Priority.GREEN;
        }

        return Priority.BLUE;
    }

    private boolean isRed(Integer hr, Double temp, Integer sys, Integer spo2) {
        return (spo2 != null && spo2 < 90) ||
                (sys != null && (sys < 90 || sys > 180)) ||
                (hr != null && hr > 130) ||
                (temp != null && temp > 39.5);
    }

    private boolean isOrange(Integer hr, Double temp, Integer sys, Integer spo2) {
        return (spo2 != null && spo2 < 95) ||
                (hr != null && hr > 110) ||
                (temp != null && temp >= 38.5) ||
                (sys != null && sys > 160);
    }

    private boolean isYellow(Integer hr, Double temp, Integer sys, Integer dia) {
        return (hr != null && hr > 90) ||
                (temp != null && temp >= 37.5) ||
                (sys != null && sys > 140) ||
                (dia != null && dia > 90);
    }

    private boolean hasAnyVitalSign(Integer hr, Double temp, Integer sys, Integer dia, Integer spo2) {
        return hr != null || temp != null || sys != null || dia != null || spo2 != null;
    }
}