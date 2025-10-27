package ma.enset.customerservice;

import ma.enset.customerservice.entites.Customer;
import ma.enset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {

        return (args) -> {
            customerRepository.save(Customer.builder()
                    .name("Driss")
                    .email("driss@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("IMAD")
                    .email("IMAD@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("ISAM")
                    .email("ISAM@gmail.com")
                    .build());
            customerRepository.findAll().forEach(C->{
                        System.out.println("===================");
                        System.out.println(C.getId());
                        System.out.println(C.getName());
                        System.out.println(C.getEmail());
                        System.out.println("===================");
                    }











            );
        };



    }
}
