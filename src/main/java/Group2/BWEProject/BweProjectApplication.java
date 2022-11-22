package Group2.BWEProject;

import Group2.BWEProject.dao.AuctionDao;
import Group2.BWEProject.dao.ProductDao;
import Group2.BWEProject.dao.UserDao;
import Group2.BWEProject.model.Auction;
import Group2.BWEProject.model.Product;
import Group2.BWEProject.model.User;
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


        /* create fake data  */
        AuctionDao auctionRepository =
                configurableApplicationContext.getBean(AuctionDao.class);
        Auction auctionDbRecord = new Auction("TestTitle", LocalDate.now(), LocalDate.of(2022, 11, 30), UUID.randomUUID(), UUID.randomUUID(), true, null, "wine");
        ProductDao productRepository =
                configurableApplicationContext.getBean(ProductDao.class);
        Product productDbRecord = new Product(UUID.randomUUID(), "TestName", "Test Description", "Test Image", 8.9, 9.2, 10);

        UserDao userRepository =
                configurableApplicationContext.getBean(UserDao.class);
        User userDbRecord = new User("TestName", "TestLastName", "email@email.com", "testpassword", true);


        /* persist into DB */
        auctionRepository.save(auctionDbRecord);
        productRepository.save(productDbRecord);
        userRepository.save(userDbRecord);

    }


}

