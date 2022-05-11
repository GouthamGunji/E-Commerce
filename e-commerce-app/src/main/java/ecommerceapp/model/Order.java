package ecommerceapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    private Integer orderId;
    private Integer productId;
    private String userId;
    private LocalDateTime orderDate;
    private Integer productQuantity;

}
