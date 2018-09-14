package com.example.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Data
@Document(collection = "users")
public class UsersDocument {

    private String _id;

    private String username;

    private String password;

    private Integer status;

}
