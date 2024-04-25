package Hospital_Project.service;

import Hospital_Project.domain.MedicalCase;
import Hospital_Project.repository.MedicalCaseRepository;

import java.util.List;

public class MedicalCaseService {

    private final MedicalCaseRepository medicalCaseRepository;

    public MedicalCaseService(MedicalCaseRepository medicalCaseRepository) {
        this.medicalCaseRepository = medicalCaseRepository;
    }

    public MedicalCase findMedicalcase() {
        return null;

    }
}
