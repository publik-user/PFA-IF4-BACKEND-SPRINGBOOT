package must.harvest.harvest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Organ {
    @Id
    @SequenceGenerator(
            name = "organ_sequence",
            sequenceName = "organ_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organ_sequence"
    )
    private Long Id;
    private String Type;
    private Date DonationDate;
    private Date ExpirationDate;
    private boolean Availability;
    private boolean ScientificResearch;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = false)
    private Member memberOrgans;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = false)
    private operation OprOrgans;

    @JsonBackReference
    @ManyToOne
    private Storage organStorage;


    public Organ() {
    }

    public Organ(String type, Date donationDate, boolean availability, boolean scientificResearch) {
        Type = type;
        DonationDate = donationDate;
        Availability = availability;
        ScientificResearch = scientificResearch;
    }

    public Organ(Long Id, String type, Date donationDate, boolean availability, boolean scientificResearch) {
        this.Id = Id;
        Type = type;
        DonationDate = donationDate;
        Availability = availability;
        ScientificResearch = scientificResearch;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Date getDonationDate() {
        return DonationDate;
    }

    public void setDonationDate(Date donationDate) {
        DonationDate = donationDate;
    }

    public Date getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        ExpirationDate = expirationDate;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    public boolean isScientificResearch() {
        return ScientificResearch;
    }

    public void setScientificResearch(boolean scientificResearch) {
        ScientificResearch = scientificResearch;
    }

    @Override
    public String toString() {
        return "Organ{" +
                "Id=" + Id +
                ", Type='" + Type + '\'' +
                ", DonationDate=" + DonationDate +
                ", ExpirationDate=" + ExpirationDate +
                ", Availability=" + Availability +
                ", ScientificResearch=" + ScientificResearch +
                '}';
    }
}
