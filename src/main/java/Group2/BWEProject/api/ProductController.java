package Group2.BWEProject.api;

import Group2.BWEProject.model.Product;
import Group2.BWEProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/products")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> selectAllProducts() {
        return new ResponseEntity<>(productService.selectAllProducts(), HttpStatus.FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Product>> selectProductById(@PathVariable("id") UUID id) {
        return new ResponseEntity(productService.selectProductById(id), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);}

    @PutMapping(path = "{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") UUID id, @RequestBody Product product) {
    return new ResponseEntity<>(productService.updateProductById(id, product),HttpStatus.CREATED);}
}
