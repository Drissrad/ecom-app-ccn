package ma.enset.billingservice;

import ma.enset.billingservice.Model.Product;
import ma.enset.billingservice.Model.customer;
import ma.enset.billingservice.entites.Bill;
import ma.enset.billingservice.entites.ProductItem;
import ma.enset.billingservice.feign.CustomerRestClient;
import ma.enset.billingservice.feign.ProductRestClient;
import ma.enset.billingservice.repository.BillRepository;
import ma.enset.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BillRepository BillRepository, ProductItemRepository ProductItemRepository , CustomerRestClient CustomerRestClient, ProductRestClient ProductRestClient, BillRepository billRepository) {
        return args -> {
            Collection<customer> customers = CustomerRestClient.GetAllCustomers().getContent();
            Collection<Product> products=ProductRestClient.getAllProduts().getContent();
            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);
                products.forEach(product->{
                    ProductItem productItem=ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(new Random().nextInt(100))
                            .Unitprice(product.getPrice())
                            .build();
                    ProductItemRepository.save(productItem);
                });
            });
        };
    }
}
