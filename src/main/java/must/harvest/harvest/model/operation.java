package must.harvest.harvest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class operation {
    @Id
    @SequenceGenerator(
            name = "oid_sequence",
            sequenceName = "oid_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "oid_sequence"
    )
    private Long OID;
    private String OprType;
    private String Hospital;
    private Date ScheduledDate;
    private boolean performed;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = false)
    private Member memberOprs;

    @JsonManagedReference
    @OneToMany(mappedBy = "OprOrgans")
    private List<Organ> usedOrgans = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "OprBlood")
    private List<BloodBag> usedBloodBags = new ArrayList<>();

    public operation() {
    }

    public operation(String oprType, String hospital, Date scheduledDate, boolean performed) {
        OprType = oprType;
        Hospital = hospital;
        ScheduledDate = scheduledDate;
        this.performed = performed;
    }

    public operation(Long OID, String oprType, String hospital, Date scheduledDate, boolean performed) {
        this.OID = OID;
        OprType = oprType;
        Hospital = hospital;
        ScheduledDate = scheduledDate;
        this.performed = performed;
    }


    public Long getOID() {
        return OID;
    }

    public void setOID(Long OID) {
        this.OID = OID;
    }

    public String getOprType() {
        return OprType;
    }

    public void setOprType(String oprType) {
        OprType = oprType;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public Date getScheduledDate() {
        return ScheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        ScheduledDate = scheduledDate;
    }

    public boolean isPerformed() {
        return performed;
    }

    public void setPerformed(boolean performed) {
        this.performed = performed;
    }

    @Override
    public String toString() {
        return "operation{" +
                "OID=" + OID +
                ", OprType='" + OprType + '\'' +
                ", Hospital='" + Hospital + '\'' +
                ", ScheduledDate=" + ScheduledDate +
                ", performed=" + performed +
                '}';
    }
}
