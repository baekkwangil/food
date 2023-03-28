package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodStarted'"
    )
    public void wheneverFoodStarted_FoodStarted(
        @Payload FoodStarted foodStarted
    ) {
        FoodStarted event = foodStarted;
        System.out.println(
            "\n\n##### listener FoodStarted : " + foodStarted + "\n\n"
        );

        // Sample Logic //
        Order.foodStarted(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodEnded'"
    )
    public void wheneverFoodEnded_FoodStarted(@Payload FoodEnded foodEnded) {
        FoodEnded event = foodEnded;
        System.out.println(
            "\n\n##### listener FoodStarted : " + foodEnded + "\n\n"
        );

        // Sample Logic //
        Order.foodStarted(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodEnded'"
    )
    public void wheneverFoodEnded_FoodEnded(@Payload FoodEnded foodEnded) {
        FoodEnded event = foodEnded;
        System.out.println(
            "\n\n##### listener FoodEnded : " + foodEnded + "\n\n"
        );
        // Sample Logic //

    }
}
