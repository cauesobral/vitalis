package com.cauesobral.vitalis.service;

import com.cauesobral.vitalis.dto.DoctorRequestDTO;
import com.cauesobral.vitalis.dto.DoctorResponseDTO;
import com.cauesobral.vitalis.exception.BusinessException;
import com.cauesobral.vitalis.model.Doctor;
import com.cauesobral.vitalis.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // criar medico
    public DoctorResponseDTO create(DoctorRequestDTO dto) {

        if (doctorRepository.existsByCrm(dto.getCrm())) {
            throw new BusinessException("Já existe um médico com esse CRM.");
        }

        Doctor doctor = new Doctor(
                dto.getFullName(),
                dto.getBirthDate(),
                dto.getGender(),
                dto.getCpf(),
                dto.getCountry(),
                dto.getState(),
                dto.getCity(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getCellphoneNumber(),
                dto.getCrm(),
                dto.getSpecialty(),
                dto.getSpecialtyRegistration(),
                dto.getAverageAppointmentDuration(),
                dto.getServiceType(),
                dto.getWorkHours(),
                dto.getWorkplace(),
                dto.getAvailableDays()
        );

        doctor = doctorRepository.save(doctor);

        return toResponse(doctor);
    }

    // encontrar todos os medicos
    public List<DoctorResponseDTO> findAll() {
        return doctorRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // encontrar medico por id
    public DoctorResponseDTO findById(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Médico não encontrado."));

        return toResponse(doctor);
    }

    // encontrar medico por crm
    public DoctorResponseDTO findByCrm(String crm) {

        Doctor doctor = doctorRepository.findByCrm(crm)
                .orElseThrow(() -> new BusinessException("Médico não encontrado."));

        return toResponse(doctor);
    }

    // alterar info medico
    public DoctorResponseDTO update(Long id, DoctorRequestDTO dto) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Médico não encontrado."));

        doctor.setFullName(dto.getFullName());
        doctor.setCity(dto.getCity());
        doctor.setState(dto.getState());
        doctor.setCountry(dto.getCountry());
        doctor.setAddress(dto.getAddress());
        doctor.setEmail(dto.getEmail());
        doctor.setCellphoneNumber(dto.getCellphoneNumber());

        doctor.setSpecialty(dto.getSpecialty());
        doctor.setSpecialtyRegistration(dto.getSpecialtyRegistration());
        doctor.setAverageAppointmentDuration(dto.getAverageAppointmentDuration());
        doctor.setServiceType(dto.getServiceType());
        doctor.setWorkHours(dto.getWorkHours());
        doctor.setWorkplace(dto.getWorkplace());
        doctor.setAvaliableDays(dto.getAvailableDays());

        doctor = doctorRepository.save(doctor);

        return toResponse(doctor);
    }

    // deletar o medico pelo id
    public void delete(Long id) {

        if (!doctorRepository.existsById(id)) {
            throw new BusinessException("Médico não encontrado.");
        }

        doctorRepository.deleteById(id);
    }

    // mapper que converte uma entidade Doctor em um DoctorResponseDTO,
    // separando o modelo interno do banco do formato exposto pela API
    private DoctorResponseDTO toResponse(Doctor doctor) {

        DoctorResponseDTO dto = new DoctorResponseDTO();

        dto.setId(doctor.getId());

        dto.setFullName(doctor.getFullName());
        dto.setBirthDate(doctor.getBirthDate());
        dto.setGender(doctor.getGender());
        dto.setCpf(doctor.getCpf());

        dto.setCity(doctor.getCity());
        dto.setState(doctor.getState());
        dto.setCountry(doctor.getCountry());
        dto.setAddress(doctor.getAddress());

        dto.setEmail(doctor.getEmail());
        dto.setCellphoneNumber(doctor.getCellphoneNumber());

        dto.setCrm(doctor.getCrm());
        dto.setSpecialty(doctor.getSpecialty());
        dto.setSpecialtyRegistration(doctor.getSpecialtyRegistration());
        dto.setAverageAppointmentDuration(doctor.getAverageAppointmentDuration());
        dto.setServiceType(doctor.getServiceType());
        dto.setWorkHours(doctor.getWorkHours());
        dto.setWorkplace(doctor.getWorkplace());
        dto.setAvailableDays(doctor.getAvaliableDays());

        return dto;
    }
}