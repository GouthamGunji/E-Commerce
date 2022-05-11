package ecommerceapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    private String userId;
    private String userName;
    private String password;
}
