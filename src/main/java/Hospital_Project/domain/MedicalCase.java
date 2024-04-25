package Hospital_Project.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MedicalCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caseName;

    private String emergency;

    @ManyToOne
    private Title title;

    @ManyToOne
    private Doctor doctor;

    @ManyToMany
    private List<Patient> patients = new ArrayList<>();


    // Getter - Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Patient> getPatientList() {
        return patients;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patients = patientList;
    }
}
