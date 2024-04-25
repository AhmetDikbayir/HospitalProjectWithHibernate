package Hospital_Project.service;

import Hospital_Project.domain.MedicalCase;
import Hospital_Project.domain.Patient;
import Hospital_Project.repository.PatientRepository;

import java.util.List;
import java.util.Scanner;

import static Hospital_Project.service.HospitalService.*;

public class PatientService {
    private Scanner scanner = new Scanner(System.in);
    private final PatientRepository patientRepository;
    private final MedicalCaseService medicalCaseService;

    public PatientService(PatientRepository patientRepository, MedicalCaseService medicalCaseService) {
        this.patientRepository = patientRepository;
        this.medicalCaseService = medicalCaseService;
    }

    public void savePatient(){
        Patient patient = new Patient();

        System.out.println("Enter patient name : ");
        patient.setName(scanner.nextLine());

        System.out.println("Enter patient lastname : ");
        patient.setLastname(scanner.nextLine());

        //hastaya medikal case ekleyeceğiz
        System.out.println("Enter patient actual case : ");
        MedicalCase medicalCase = medicalCaseService.findMedicalcase();
        patient.getMedicalCases().add(medicalCase);



        patientRepository.save(patient);
        System.out.println("Patient was successfully added!!");
    }

    public Patient findPatientById(Long id){
        Patient patient = patientRepository.find(id);
        System.out.println("-------------------------");
        if(patient!= null){
            System.out.println(patient);
            System.out.println("-------------------------");
           return patient;
        }else {
            System.out.println("This patient could not found!!!");
        }
        System.out.println("-------------------------");
        return null;
    }

    public void deletePatient(Long id){
        Patient foundPatient = findPatientById(id);
        if(foundPatient != null){
            patientRepository.delete(foundPatient);
            System.out.println("Patient was deleted successfully!!");
        }else {
            System.out.println("Patient was not found!!!");
        }
    }


    public void findAllPatients() {
        List<Patient> patientList = patientRepository.getAll();
        System.out.println("--------------- ALL PATIENTS ------------------");
        if(!patientList.isEmpty()){
            for(Patient patient : patientList){
                System.out.println(patient);
            }
        }else {
            System.out.println("Patient list is empty!!!");
        }

    }
}
