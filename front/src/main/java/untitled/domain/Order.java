package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.FrontApplication;
import untitled.domain.FoodStarted;
import untitled.domain.OrderCanceled;
import untitled.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        FoodStarted foodStarted = new FoodStarted(this);
        foodStarted.publishAfterCommit();

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void foodStarted(FoodStarted foodStarted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        FoodStarted foodStarted = new FoodStarted(order);
        foodStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(foodStarted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            FoodStarted foodStarted = new FoodStarted(order);
            foodStarted.publishAfterCommit();

         });
        */

    }

    public static void foodStarted(FoodEnded foodEnded) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        FoodStarted foodStarted = new FoodStarted(order);
        foodStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(foodEnded.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            FoodStarted foodStarted = new FoodStarted(order);
            foodStarted.publishAfterCommit();

         });
        */

    }
}
