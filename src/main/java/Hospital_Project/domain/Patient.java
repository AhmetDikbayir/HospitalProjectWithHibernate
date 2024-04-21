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
    @Column(nullable = false)
    private String actualCase;

    @ManyToMany(mappedBy = "patientList", fetch = FetchType.EAGER)
    private List<Doctor> doctorList;

    //Constructors *********************

    public Patient() {
    }

    public Patient(String name, String lastname, String actualCase) {
        this.name = name;
        this.lastname = lastname;
        this.actualCase = actualCase;
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

    public String getActualCase() {
        return actualCase;
    }

    public void setActualCase(String actualCase) {
        this.actualCase = actualCase;
    }

    //toString()  ***********************


    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", actualCase='" + actualCase + '\'' +
                '}';
    }
}


