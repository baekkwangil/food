package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class StartDelivery extends AbstractEvent {

    private Long id;

    public StartDelivery(Delivery aggregate) {
        super(aggregate);
    }

    public StartDelivery() {
        super();
    }
}
