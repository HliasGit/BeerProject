package Group2.BWEProject.api;

import Group2.BWEProject.model.Product;
import Group2.BWEProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public Product selectProductById(@PathVariable("id") UUID id){
        return productService.selectProductById(id);
    }

    @DeleteMapping(path = "/{id}")
    public int deleteProductById(@PathVariable("id") UUID id)
    { return productService.deleteProductById(id);}

    @PutMapping(path = "{id}")
    public int updateProductById(@PathVariable("id") UUID id, @RequestBody Product product)
    { return productService.updateProductById(id, product);}

}
