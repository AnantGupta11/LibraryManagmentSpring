package com.infy.LibraryManagment.repository;

import com.infy.LibraryManagment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class UserCacheRepository {

    @Value("${redis.user.details.timeout}")
    private int timeout;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static String userKey="user::";

    public User getUser(String email){
        String key=userKey+email;
        return (User)redisTemplate.opsForValue().get(key);
    }

    public void setUser(String email, User user){
        String key=userKey+email;
         redisTemplate.opsForValue().set(key,user,timeout, TimeUnit.MINUTES);
    }
}
