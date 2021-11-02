package must.harvest.harvest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class BloodBag {
    @Id
    @SequenceGenerator(
            name = "bid_sequence",
            sequenceName = "bid_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bid_sequence"
    )
    private Long BID;
    private String bloodType;
    private Date DonationDate;
    private Date ExpirationDate;
    private boolean availability;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = false)
    private Member memberBloodBag;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = true)
    private operation OprBlood;

    @JsonBackReference
    @ManyToOne
    private Storage bloodStorage;

    public BloodBag() {
    }

    public BloodBag(String bloodType, Date donationDate, Date expirationDate, boolean availability) {
        this.bloodType = bloodType;
        DonationDate = donationDate;
        ExpirationDate = expirationDate;
        this.availability = availability;
    }

    public BloodBag(Long BID, String bloodType, Date donationDate, Date expirationDate, boolean availability) {
        this.BID = BID;
        this.bloodType = bloodType;
        DonationDate = donationDate;
        ExpirationDate = expirationDate;
        this.availability = availability;
    }


    public Long getBID() {
        return BID;
    }

    public void setBID(Long BID) {
        this.BID = BID;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Member getMemberBloodBag() {
        return memberBloodBag;
    }

    public void setMemberBloodBag(Member memberBloodBag) {
        this.memberBloodBag = memberBloodBag;
    }

    public operation getOprBlood() {
        return OprBlood;
    }

    public void setOprBlood(operation oprBlood) {
        OprBlood = oprBlood;
    }

    public Storage getBloodStorage() {
        return bloodStorage;
    }

    public void setBloodStorage(Storage bloodStorage) {
        this.bloodStorage = bloodStorage;
    }

    @Override
    public String toString() {
        return "BloodBag{" +
                "BID=" + BID +
                ", bloodType='" + bloodType + '\'' +
                ", DonationDate=" + DonationDate +
                ", ExpirationDate=" + ExpirationDate +
                ", availability=" + availability +
                '}';
    }
}
