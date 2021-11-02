package must.harvest.harvest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import must.harvest.harvest.IdClasses.WaitListId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@IdClass(WaitListId.class)

public class Member_WaitList {
    @Id
    private Long membercin;
    @Id
    private Long waitListId;
    private Date addition_date;
}
