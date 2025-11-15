package ma.enset.billingservice.feign;

import ma.enset.billingservice.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable  String id);
    @GetMapping("/api/products")
    PagedModel<Product> getAllProduts();
}
