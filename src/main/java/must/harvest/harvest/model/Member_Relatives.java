package must.harvest.harvest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import must.harvest.harvest.IdClasses.RelativeId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@IdClass(RelativeId.class)

public class Member_Relatives {

    @Id
    private Long mcin;

    @Id
    private Long relative;
}
