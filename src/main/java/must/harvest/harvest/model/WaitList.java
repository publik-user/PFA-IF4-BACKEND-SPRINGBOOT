package must.harvest.harvest.model;

import javax.persistence.*;

@Entity
@Table
public class WaitList {
    @Id
    @SequenceGenerator(
            name = "wid_sequence",
            sequenceName = "wid_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wid_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long wid;
    private String type;


    public WaitList() {
    }

    public WaitList(String type) {
        this.type = type;
    }

    public WaitList(Long wid, String type) {
        this.wid = wid;
        this.type = type;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WaitList{" +
                "wid=" + wid +
                ", type='" + type + '\'' +
                '}';
    }
}
