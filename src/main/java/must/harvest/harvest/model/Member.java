package must.harvest.harvest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @Column(nullable = false, updatable = false)
    private Long CIN;
    @Column(nullable = false)
    private String password;
    private String Nom;
    private String Prenom;
    private String EMAIL;
    private String Address;
    private String Sexe;
    private String Profession;
    private Date BirthDate;
    private Date DeathDate;
    private String CauseOfDeath;
    private String BloodType;
    private String Token;

    @JsonManagedReference
    @OneToMany(mappedBy = "memberOrgans")
    private List<Organ> donatedOrgans = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "memberOprs")
    private List<operation> operations = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "memberBloodBag")
    private List<BloodBag> DonatedBlood = new ArrayList<>();


    public Member(Long cin, String nom, String prenom, String email, String address, String sexe, String profession, Date birthDate, Date deathDate, String causeOfDeath, String bloodType) {
        CIN = cin;
        Nom = nom;
        Prenom = prenom;
        EMAIL = email;
        Address = address;
        Sexe = sexe;
        Profession = profession;
        BirthDate = birthDate;
        DeathDate = deathDate;
        CauseOfDeath = causeOfDeath;
        BloodType = bloodType;
    }


}
