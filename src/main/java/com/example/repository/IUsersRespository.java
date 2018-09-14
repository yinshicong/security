package com.example.repository;

import com.example.entity.UsersDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Repository
public interface IUsersRespository extends MongoRepository<UsersDocument,String> {

    UsersDocument findByUsername(String username);

}
