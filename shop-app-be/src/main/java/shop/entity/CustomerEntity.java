package shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerEntity extends BaseEntity
{
    @OneToMany(mappedBy = "customer")
    private Set<OrderEntity> orderEntities;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;

    public CustomerEntity(String firstName, String lastName, String username, String password, String emailAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }
}
