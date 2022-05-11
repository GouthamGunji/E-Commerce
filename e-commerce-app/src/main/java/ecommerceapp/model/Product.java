package ecommerceapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    private Integer productId;
    private String productName;
    private Double msrp;
    private Integer quantityInStock;
    private String productVendor;
}
