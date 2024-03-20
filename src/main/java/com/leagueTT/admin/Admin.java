package com.leagueTT.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class Admin {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String password;

}
