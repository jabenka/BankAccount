package com.Banking.bank.Persistence.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person", schema = "bank")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "Name", nullable = false, length = 45)
    private String name;

    @Column(name = "phone", nullable = false, length = 45)
    private String phone;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "password", nullable = false, length = 45)
    private String password;
    public Person(String name, String phone, String email, String role, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.password = password;
    }

}