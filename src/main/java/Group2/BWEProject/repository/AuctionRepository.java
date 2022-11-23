package Group2.BWEProject.repository;

import Group2.BWEProject.model.Auction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("auctionDao")
public interface AuctionRepository extends CrudRepository<Auction,UUID> {


}
