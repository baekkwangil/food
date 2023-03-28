package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class FoodStarted extends AbstractEvent {

    private Long id;

    public FoodStarted() {
        super();
    }
}
