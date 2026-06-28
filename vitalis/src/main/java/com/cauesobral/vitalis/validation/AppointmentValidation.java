package com.cauesobral.vitalis.validation;

import com.cauesobral.vitalis.dto.AppointmentRequestDTO;
import com.cauesobral.vitalis.exception.BusinessException;

import java.time.LocalDateTime;

public class AppointmentValidation {

    private AppointmentValidation() {}

    public static void validate(AppointmentRequestDTO dto) {
        validateScheduledAt(dto.getScheduledAt());
    }

    private static void validateScheduledAt(LocalDateTime scheduledAt) {
        if (scheduledAt == null) return;
        if (scheduledAt.isBefore(LocalDateTime.now())) {
            throw new BusinessException("A data do agendamento não pode estar no passado");
        }
    }
}
