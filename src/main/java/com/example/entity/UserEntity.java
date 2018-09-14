package com.example.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Data
@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    private String salt;

    private String role;

}
