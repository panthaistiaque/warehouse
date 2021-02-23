package com.ihit.warehouse.mscproject.users.DataBind;

import com.ihit.warehouse.mscproject.auth.model.Role;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by User on 2/22/2021.
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    //private String role;
    @Column(length = 11)
    private String phone;
    @Column(nullable = false, length = 64)
    private String password;

    @Transient
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList;
}
