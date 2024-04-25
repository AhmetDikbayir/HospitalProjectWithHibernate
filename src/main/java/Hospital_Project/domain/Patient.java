package Hospital_Project.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;

    @ManyToMany(mappedBy = "patients")
    private List<MedicalCase> medicalCases;

    @ManyToMany(mappedBy = "patientList", fetch = FetchType.EAGER)
    private List<Doctor> doctorList;

    //Constructors *********************

    public Patient() {
    }

    //toString() ****************
    public Patient(String name, String lastname, List<MedicalCase> medicalCases) {
        this.name = name;
        this.lastname = lastname;
        this.medicalCases = medicalCases;
    }

    //Getter - Setter ***************************


    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<MedicalCase> getMedicalCases() {
        return medicalCases;
    }

    public void setMedicalCases(List<MedicalCase> medicalCases) {
        this.medicalCases = medicalCases;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", medicalCases=" + medicalCases +
                '}';
    }
}


