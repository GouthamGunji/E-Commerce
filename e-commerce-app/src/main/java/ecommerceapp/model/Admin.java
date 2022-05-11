package ecommerceapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ADMIN")
public class Admin {

    @Id
    private String name;
    private String password;
}
