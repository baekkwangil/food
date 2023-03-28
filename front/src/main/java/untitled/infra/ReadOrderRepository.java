package untitled.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "readOrders",
    path = "readOrders"
)
public interface ReadOrderRepository
    extends PagingAndSortingRepository<ReadOrder, Long> {}
