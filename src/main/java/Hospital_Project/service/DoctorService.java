package Hospital_Project.service;

import Hospital_Project.domain.Doctor;
import Hospital_Project.repository.DoctorRepository;

import java.util.Scanner;

public class DoctorService{

    private final Scanner scanner = new Scanner(System.in);

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void saveDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Enter doctor name : ");
        doctor.setName(scanner.nextLine());
        System.out.println("Enter doctor lastname : ");
        doctor.setLastname(scanner.nextLine());
        System.out.println("Enter doctor title : ");
        doctor.setTitle(scanner.nextLine());
        System.out.println("Enter doctor department : ");
        doctor.setDepartment(scanner.nextLine());

        doctorRepository.save(doctor);
        System.out.println("Doctor was saved successfully!!");
    }

    public Doctor findDoctorById(Long id) {
        Doctor foundDoctor = doctorRepository.find(id);
        if(foundDoctor != null){
            System.out.println("-------------------");
            System.out.println(foundDoctor);
            System.out.println("-------------------");
        }else {
            System.out.println("Doctor could not found");
        }
        return foundDoctor;
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.delete(id);
        System.out.println("Doctor was deleted successfully!! Doctor ID : " + doctor.getId());
    }

    public void findAllDoctor() {
    }
}
