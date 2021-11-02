package must.harvest.harvest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Storage {
    @Id
    @SequenceGenerator(
            name = "storage_sequence",
            sequenceName = "storage_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_sequence"
    )
    private Long SID;
    private String name;
    private String location;

    @JsonManagedReference
    @OneToMany(mappedBy = "bloodStorage")
    List<BloodBag> storedBlood = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "organStorage")
    List<Organ> storedOrgans = new ArrayList<>();

    public Storage() {
    }

    public Storage(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Storage(Long SID, String name, String location) {
        this.SID = SID;
        this.name = name;
        this.location = location;
    }

    public Long getSID() {
        return SID;
    }

    public void setSID(Long SID) {
        this.SID = SID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "SID=" + SID +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", storedBlood=" + storedBlood +
                ", storedOrgans=" + storedOrgans +
                '}';
    }
}
