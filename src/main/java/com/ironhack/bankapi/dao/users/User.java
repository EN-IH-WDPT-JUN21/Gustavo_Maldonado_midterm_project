package com.ironhack.bankapi.dao.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<Role> roles; //This relationship would change if roles have powers, so each user can have only one role

//    public User(String username, String password, Set<Role> roles) {
//        this.username = username;
//        this.password = password;
//        this.roles = roles;
//    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
