package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/9/12 0012.
 */
@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Integer> {
}
