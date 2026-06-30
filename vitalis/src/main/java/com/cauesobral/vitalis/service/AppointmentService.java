package com.cauesobral.vitalis.service;

import com.cauesobral.vitalis.dto.AppointmentRequestDTO;
import com.cauesobral.vitalis.dto.AppointmentResponseDTO;
import com.cauesobral.vitalis.exception.BusinessException;
import com.cauesobral.vitalis.model.Appointment;
import com.cauesobral.vitalis.model.AppointmentStatus;
import com.cauesobral.vitalis.model.Doctor;
import com.cauesobral.vitalis.model.Patient;
import com.cauesobral.vitalis.repository.AppointmentRepository;
import com.cauesobral.vitalis.repository.DoctorRepository;
import com.cauesobral.vitalis.repository.PatientRepository;
import com.cauesobral.vitalis.validation.AppointmentValidation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              PatientRepository patientRepository,
                              DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public AppointmentResponseDTO schedule(AppointmentRequestDTO dto) {
        AppointmentValidation.validate(dto);

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new BusinessException("Paciente não encontrado com id: " + dto.getPatientId()));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new BusinessException("Médico não encontrado com id: " + dto.getDoctorId()));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setScheduledAt(dto.getScheduledAt());
        appointment.setStatus(AppointmentStatus.SCHEDULED);

        Appointment saved = appointmentRepository.save(appointment);
        return AppointmentResponseDTO.fromAppointment(saved);
    }

    public AppointmentResponseDTO arrive(Long appointmentId) {
        Appointment appointment = findOrThrow(appointmentId);

        if (appointment.getStatus() != AppointmentStatus.SCHEDULED) {
            throw new BusinessException("Apenas agendamentos com status SCHEDULED podem registrar chegada");
        }

        appointment.setStatus(AppointmentStatus.ARRIVED);
        appointment.setArrivedAt(LocalDateTime.now());

        Appointment saved = appointmentRepository.save(appointment);
        return AppointmentResponseDTO.fromAppointment(saved);
    }

    public AppointmentResponseDTO advanceToTriaged(Long appointmentId) {
        Appointment appointment = findOrThrow(appointmentId);

        if (appointment.getStatus() != AppointmentStatus.ARRIVED) {
            throw new BusinessException("Apenas agendamentos com status ARRIVED podem avançar para triagem");
        }

        appointment.setStatus(AppointmentStatus.TRIAGED);

        Appointment saved = appointmentRepository.save(appointment);
        return AppointmentResponseDTO.fromAppointment(saved);
    }

    public AppointmentResponseDTO advanceToInConsultation(Long appointmentId) {
        Appointment appointment = findOrThrow(appointmentId);

        if (appointment.getStatus() != AppointmentStatus.TRIAGED) {
            throw new BusinessException("Apenas agendamentos com status TRIAGED podem entrar em consulta");
        }

        appointment.setStatus(AppointmentStatus.IN_CONSULTATION);

        Appointment saved = appointmentRepository.save(appointment);
        return AppointmentResponseDTO.fromAppointment(saved);
    }

    public AppointmentResponseDTO discharge(Long appointmentId) {
        Appointment appointment = findOrThrow(appointmentId);

        if (appointment.getStatus() != AppointmentStatus.IN_CONSULTATION) {
            throw new BusinessException("Apenas agendamentos com status IN_CONSULTATION podem receber alta");
        }

        appointment.setStatus(AppointmentStatus.DISCHARGED);

        Appointment saved = appointmentRepository.save(appointment);
        return AppointmentResponseDTO.fromAppointment(saved);
    }

    public AppointmentResponseDTO cancel(Long appointmentId) {
        Appointment appointment = findOrThrow(appointmentId);

        if (appointment.getStatus() == AppointmentStatus.IN_CONSULTATION
                || appointment.getStatus() == AppointmentStatus.DISCHARGED
                || appointment.getStatus() == AppointmentStatus.CANCELLED) {
            throw new BusinessException("Não é possível cancelar um agendamento com status: " + appointment.getStatus());
        }

        appointment.setStatus(AppointmentStatus.CANCELLED);

        Appointment saved = appointmentRepository.save(appointment);
        return AppointmentResponseDTO.fromAppointment(saved);
    }

    private Appointment findOrThrow(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Agendamento não encontrado com id: " + id));
    }
}
