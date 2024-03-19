package com.example.library;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "User_FirstName", nullable = false)
    private String firstName;

    @Column(name = "User_LastName", nullable = false)
    private String lastName;

    @Column(name = "User_Email", nullable = false)
    private String email;

    @Column(name = "User_PhoneNo", nullable = false)
    private String phoneNo;
}
