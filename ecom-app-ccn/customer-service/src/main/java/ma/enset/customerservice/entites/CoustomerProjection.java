package ma.enset.customerservice.entites;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all",types = Customer.class)
public interface CoustomerProjection {
    String getName();
    String getEmail();

}
