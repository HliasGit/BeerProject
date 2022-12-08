package Group2.BWEProject;

import Group2.BWEProject.repository.AuctionRepository;
import Group2.BWEProject.repository.ProductRepository;
import Group2.BWEProject.repository.UserRepository;
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
        System.out.println("Springboot Application has started");


        /* create fake data  */
        AuctionRepository auctionRepository =
                configurableApplicationContext.getBean(AuctionRepository.class);
        Auction auctionDbRecord = new Auction("TestTitle", LocalDate.now(), LocalDate.of(2022, 11, 30), UUID.randomUUID(), UUID.randomUUID(), true, null, "wine");
        ProductRepository productRepository =
                configurableApplicationContext.getBean(ProductRepository.class);
        Product productDbRecord = new Product(UUID.randomUUID(), "TestName", "Test Description", "Test Image", 8.9, 9.2, 10);

        UserRepository userRepository =
                configurableApplicationContext.getBean(UserRepository.class);
        User userDbRecord = new User("TestName", "TestLastName", "email@email.com", "testpassword", true);


        /* persist into DB */
        auctionRepository.save(auctionDbRecord);
        productRepository.save(productDbRecord);
        userRepository.save(userDbRecord);

    }


}

