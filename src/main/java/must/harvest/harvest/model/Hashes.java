package must.harvest.harvest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Hashes {
    @Id
    private String stuff;

    public Hashes() {
    }

    public Hashes(String stuff) {
        this.stuff = stuff;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }
}
