package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.StoreApplication;
import untitled.domain.OrderAccepted;
import untitled.domain.OrderRejected;

@Entity
@Table(name = "Food_table")
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    public static FoodRepository repository() {
        FoodRepository foodRepository = StoreApplication.applicationContext.getBean(
            FoodRepository.class
        );
        return foodRepository;
    }
}
