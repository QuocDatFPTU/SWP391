/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false, updatable = false)
    private Long userID;

    @NotBlank(message = "username can't be empty")
    @Size(max = 100, min = 5, message = "username must have more than 5 characters")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Password cant be empty")
    @Size(max = 100, min = 5, message = "Password must be have more than 5 character")
    @Column(name = "password")
    private String password;

    @NotBlank
    @Size(max = 40, min = 1, message = "FirstName must have more than 1 character")
    @Column(name = "firstname")
    private String firstName;

    @NotBlank
    @Size(max = 40, min = 1, message = "LastName must have more than 1 character")
    @Column(name = "lastname")
    private String lastName;

    @NotBlank
    @Size(max = 40)
    @Email(message = "email must be in the correct format")
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 12, min = 10, message = "phonenumber must have atleast than 10 number")
    @Column(name = "phone")
    private String phone;

    @NotBlank
    @Size(max = 40, min = 1, message = "Gender cant be empty")
    @Column(name = "gender")
    private String gender;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "isActive")
    private boolean isActive;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {
                @JoinColumn(name = "user_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "userID", fetch = FetchType.EAGER)
    private Set<StudentRegistration> Register = new HashSet<>();

    public User(User user) {
        this.userID = user.userID;
        this.username = user.username;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.phone = user.phone;
        this.gender = user.gender;
        this.avatar = user.avatar;
        this.isActive = user.isActive;
    }
}
