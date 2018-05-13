package com.watchers.repository;

import com.watchers.common.Mapper;
import com.watchers.model.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HttpSessionMutexListener;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Mapper
@Component
public interface UserMapper {
    public Users getByEmail(String email);
    public void updateToken(Map<String, Object> param);
    public void addUser(Map<String, Object> param);
    public boolean login(Users users);
    public void logout(HttpSession session);
    public Users getByID(String id);
}
