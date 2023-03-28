package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ReadDelivery_table")
@Data
public class ReadDelivery {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
