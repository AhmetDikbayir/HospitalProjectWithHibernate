package Hospital_Project.controller;
import Hospital_Project.config.HibernateUtils;
import Hospital_Project.domain.Patient;
import Hospital_Project.repository.DoctorRepository;
import Hospital_Project.repository.HospitalRepository;
import Hospital_Project.repository.PatientRepository;
import Hospital_Project.service.DoctorService;
import Hospital_Project.service.HospitalService;
import Hospital_Project.service.PatientService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static Hospital_Project.service.HospitalService.*;



public class HospitalRunner {

    private static Scanner scanner = new Scanner(System.in);


    public static void displayHospitalManagementSystemMenu() {
        HospitalRepository hospitalRepository = new HospitalRepository();
        HospitalService hospitalService = new HospitalService(hospitalRepository);

        PatientRepository patientRepository = new PatientRepository();
        PatientService patientService = new PatientService(patientRepository);

        DoctorRepository doctorRepository = new DoctorRepository();
        DoctorService doctorService = new DoctorService(doctorRepository, patientService);


        boolean exit = false;
        while (!exit) {
            System.out.println("========= Hospital Management System =========");
            System.out.println("1.Hospital Operations");
            System.out.println("2.Doctor Operations");
            System.out.println("3.Patient Operations");
            System.out.println("0. Exit");
            System.out.println("Enter your choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayHospitalOperationsMenu(hospitalService);
                    break;
                case 2:
                    displayDoctorOperationsMenu(doctorService);
                    break;
                case 3:
                    displayPatientOperationsMenu(patientService);
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good Bye...");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Invalid choice, please try again ");
                    break;
            }
        }
    }

    public static void displayHospitalOperationsMenu(HospitalService hospitalService) {

    }

    public static void displayDoctorOperationsMenu(DoctorService doctorService) {

        System.out.println("Doctor Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Doctor Operations ====");
            System.out.println("1. Add a new doctor");
            System.out.println("2. Find Doctor By ID");
            System.out.println("3. Delete Doctor By ID");
            System.out.println("4. Find All Doctors");
            System.out.println("5. Update Doctor By ID");
            System.out.println("6. Add Patient to Doctor : ");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    doctorService.saveDoctor();
                    break;
                case 2:
                    System.out.println("Enter patient ID : ");
                    doctorService.findDoctorById(scanner.nextLong());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Enter patient ID : ");
                    doctorService.deleteDoctor(scanner.nextLong());
                    scanner.nextLine();
                    break;
                case 4:
                    doctorService.findAllDoctor();
                    break;
                case 5:

                    break;
                case 6:
                    doctorService.addPatientToDoctor();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }


    public static void displayPatientOperationsMenu(PatientService patientService) {
        System.out.println("Patient Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Patient Operations ====");
            System.out.println("1. Add a new patient");
            System.out.println("2. Find Patient By ID");
            System.out.println("3. Delete Patient By ID");
            System.out.println("4. Find All Patients");
            System.out.println("5. Update Patient By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    patientService.savePatient();
                    break;
                case 2:
                    System.out.println("Enter patient ID : ");
                    patientService.findPatientById(scanner.nextLong());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Enter patient ID : ");
                    patientService.deletePatient(scanner.nextLong());
                    scanner.nextLine();
                    break;
                case 4:
                    patientService.findAllPatients();

                    break;
                case 5:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }
}




