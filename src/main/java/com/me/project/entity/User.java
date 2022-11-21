/*
package com.me.project.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
                            @UniqueConstraint(columnNames = "email")})
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Column(unique = true, nullable = false)
    @Size(max = 100)
    private String username;

    @Getter @Setter
    @Column(unique = true) @Email
    @Size(max = 100)
    private String email;

    @Getter @Setter
    @Size(max = 100)
    private String password;



    public User(String username, String email, String password){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    private String role ="store";

    @Getter @Setter
    private boolean enabled;

    @Getter @Setter
    private boolean tokenExpired;

    @ManyToMany()
    @JoinTable(name = "role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @Getter @Setter
    private Set<Role> roles = new HashSet<>();

Order o = em.find(Order.class, 1L);

OrderItem i = new OrderItem();
i.setOrder(o);

em.persist(i);


Order o = em.find(Order.class, 1L);

OrderItem i = new OrderItem();

o.getItems().add(i);

em.persist(i);
}
*/
