package Group2.BWEProject.repository;

import Group2.BWEProject.model.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("offerDao")
public interface OfferRepository extends CrudRepository<Offer, UUID> {
}
