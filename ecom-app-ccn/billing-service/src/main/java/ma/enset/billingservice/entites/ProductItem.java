package ma.enset.billingservice.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import ma.enset.billingservice.Model.Product;


@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productId;

    @ManyToOne
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private  int quantity;
    private double Unitprice;
    @Transient
    private Product product;


}
