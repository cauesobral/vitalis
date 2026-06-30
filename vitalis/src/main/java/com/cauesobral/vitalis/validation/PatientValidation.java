package com.cauesobral.vitalis.validation;

import com.cauesobral.vitalis.dto.PatientRequestDTO;
import com.cauesobral.vitalis.exception.BusinessException;
import com.cauesobral.vitalis.util.CpfUtils;
import com.cauesobral.vitalis.util.DateUtils;
//verifica se o paciente é valido
public class PatientValidation {

    private PatientValidation() {}
    //recebe os dados do paciente pra verificar se eh valido ou nao
    public static void validate(PatientRequestDTO dto) {
        validateCpf(dto.getCpf());
        validateBirthDate(dto);
        validateBodyMeasurements(dto);
    }

    private static void validateCpf(String cpf) {
        if (!CpfUtils.isValid(cpf)) {
            throw new BusinessException("CPF inválido: " + cpf);
        }
    }

    private static void validateBirthDate(PatientRequestDTO dto) {
        if (dto.getBirthDate() == null) return;
        if (!DateUtils.isPastDate(dto.getBirthDate())) {
            throw new BusinessException("Data de nascimento não pode ser uma data futura");
        }
    }

    private static void validateBodyMeasurements(PatientRequestDTO dto) {
        if (dto.getHeight() < 0) {
            throw new BusinessException("Altura não pode ser negativa");
        }
        if (dto.getWeight() < 0) {
            throw new BusinessException("Peso não pode ser negativo");
        }
    }
}
