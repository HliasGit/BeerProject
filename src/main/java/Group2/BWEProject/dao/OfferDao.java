package Group2.BWEProject.dao;

import Group2.BWEProject.model.Offer;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("offerDao")
public interface OfferDao extends CrudRepository<Offer, UUID>{}
