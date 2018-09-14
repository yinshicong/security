package com.example.service.impl;

import com.example.entity.UsersDocument;
import com.example.repository.IUsersRespository;
import com.example.service.IMongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13 0013.
 */
@Service
public class MongoUserServiceImpl implements IMongoUserService {

    @Autowired
    private IUsersRespository usersRespository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if(StringUtils.isEmpty(s)){
            return null;
        }
        UsersDocument usersDocument = usersRespository.findByUsername(s);
        if(usersDocument == null){
            return null;
        }
        //创建权限列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        User user = new User(
                usersDocument.getUsername(),
                usersDocument.getPassword(),
                authorities);
        return user;

    }
}
