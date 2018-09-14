//package com.example.config;
//
//import org.springframework.security.access.AccessDecisionVoter;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.vote.AbstractAccessDecisionManager;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by Administrator on 2018/9/13 0013.
// */
//@Component
//public class MyAbstractAccessDecisionManager extends AbstractAccessDecisionManager {
//
//    public MyAbstractAccessDecisionManager(List<AccessDecisionVoter<?>> decisionVoters) {
//        super(decisionVoters);
//    }
//
//    @Override
//    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
//        System.out.println("decide run...");
//    }
//}
