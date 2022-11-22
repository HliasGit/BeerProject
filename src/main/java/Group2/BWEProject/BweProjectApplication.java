package Group2.BWEProject;

import Group2.BWEProject.dao.AuctionDao;
import Group2.BWEProject.dao.ProductDao;
import Group2.BWEProject.model.Auction;
import Group2.BWEProject.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class BweProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(BweProjectApplication.class, args);


        AuctionDao auctionRepository =
                configurableApplicationContext.getBean(AuctionDao.class);
        Auction auctionDbRecord = new Auction("Test1", LocalDate.now(), LocalDate.of(2022, 11, 30), UUID.randomUUID(), UUID.randomUUID(), true, null, "wine");
        //persist into DB
        auctionRepository.save(auctionDbRecord);

        ProductDao productRepository =
                configurableApplicationContext.getBean(ProductDao.class);
        Product productDbRecord = new Product(UUID.randomUUID(),"ASD", "kop","jjj",8.9,9.2,10);
        //persist into DB
        productRepository.save(productDbRecord);
    }


}

