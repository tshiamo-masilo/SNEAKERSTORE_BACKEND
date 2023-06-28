package com.sneaker.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @Column(name="id")
    private Long id;

    private String password;
    private String type;
}
