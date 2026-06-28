package com.cauesobral.vitalis.model;

public enum AppointmentStatus {
    SCHEDULED,       // Já agendou um horário para ir à clínica
    ARRIVED,         // Já chegou no hospital/clínica
    TRIAGED,         // Já passou pela triagem
    IN_CONSULTATION, // Está em consulta
    DISCHARGED,      // Já recebeu alta
    CANCELLED        // Cancelado
}
