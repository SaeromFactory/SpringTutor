package com.han.repositories;

import com.han.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Created by high on 2017. 11. 18..
 */
@Mapper
public interface UserMapper {
    public User getByEmail(String email);
    public void updateToken(Map<String, Object> param);
}
