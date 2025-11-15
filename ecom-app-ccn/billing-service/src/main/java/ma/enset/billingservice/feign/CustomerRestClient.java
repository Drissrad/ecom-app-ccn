package ma.enset.billingservice.feign;

import ma.enset.billingservice.Model.customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
  customer GetCustomerById(@PathVariable Long id);
    @GetMapping("/api/customers")
    PagedModel<customer> GetAllCustomers();
}