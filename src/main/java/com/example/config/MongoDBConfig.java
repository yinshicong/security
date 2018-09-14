//package com.example.config;
//
//import com.mongodb.MongoClient;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
///**
// * Created by Administrator on 2018/9/10 0010.
// */
//@Configuration
//public class MongoDBConfig {
//
//    @Configuration
//    @EnableMongoRepositories("com.example.repository")
//    public class MongoConfig
//            extends AbstractMongoConfiguration
//    {
//
//        @Override
//        public MongoClient mongoClient() {
//            return new MongoClient("101.132.111.57",27017);
//        }
//
//        @Override
//        protected String getDatabaseName() {
//            return "test";
//        }
//
//    }
//
//
//}
