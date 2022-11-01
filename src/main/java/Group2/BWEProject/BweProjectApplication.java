package Group2.BWEProject;

import Group2.BWEProject.dao.ProductDao;
import Group2.BWEProject.dao.ProductDataAccessService;
import Group2.BWEProject.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class BweProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BweProjectApplication.class, args);
	}

}


//package Group2.BWEProject;
//
//        import Group2.BWEProject.dao.ProductDao;
//        import Group2.BWEProject.dao.ProductDataAccessService;
//        import Group2.BWEProject.model.Product;
//        import org.springframework.boot.SpringApplication;
//        import org.springframework.boot.autoconfigure.SpringBootApplication;
//        import org.springframework.context.ConfigurableApplicationContext;
//
//        import java.time.LocalDate;
//        import java.util.UUID;
//
//@SpringBootApplication
//public class BweProjectApplication {
//
//package Group2.BWEProject;
//
//import Group2.BWEProject.dao.ProductDao;
//import Group2.BWEProject.dao.ProductDataAccessService;
//import Group2.BWEProject.model.Product;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import java.time.LocalDate;
//import java.util.UUID;
//
//    @SpringBootApplication
//    public class BweProjectApplication {
//
//        public static void main(String[] args) {
//            ConfigurableApplicationContext configurableApplicationContext =
//                    SpringApplication.run(Group2.BWEProject.BweProjectApplication.class, args);
//            Product productRepository = configurableApplicationContext.getBean(ProductDataAccessService.class);
//            ProductDao productRepository = configurableApplicationContext.getBean(ProductDao.class);
//            ///TODO
//            Product productDbRecord = new Product("ActionOne", LocalDate.now(), LocalDate.of(2022, 11, 30), UUID.randomUUID(), UUID.randomUUID(), true);
//
//            //persist into DB
//            productRepository.insertProduct(productDbRecord);
//            productRepository.save(productDbRecord);
//        }
//    }
//}

