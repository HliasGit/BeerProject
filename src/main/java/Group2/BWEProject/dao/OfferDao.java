package Group2.BWEProject.dao;

import Group2.BWEProject.model.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("offerDao")
public interface OfferDao extends CrudRepository<Offer, UUID> {
}
