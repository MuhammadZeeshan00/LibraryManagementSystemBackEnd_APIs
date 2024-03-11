package com.example.library;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "User_FirstName")
    private String firstName;

    @Column(name = "User_LastName")
    private String lastName;

    @Column(name = "User_Email")
    private String email;

    @Column(name = "User_PhoneNo")
    private String phoneNo;
}
