package com.han.services;

import com.han.models.CommonResponse;
import com.han.models.User;
import com.han.repositories.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by high on 2017. 11. 18..
 */
@Service
public class UserService {
    @Autowired private UserMapper userMapper;

    /*
    과제 2
    패스워드 인증시 암호 화된 토큰을 생성하고
    DB에 토큰을 저장해보세요!

    *힌트는 파라미터의 user에 다가 setToken해서 토큰값을 너으면 되요.
    암호화 방법은 랜덤값으로 만들어도 되고, 조금 더 공부를 하고 싶다면
    RSA 나 그외의 암호를 사용하는 함수를 하나 만들어서 암호화는 것도 괜찮은 것 같아요!
     */

    public CommonResponse login(User user){
        if(user.getEmail() == null)
            return new CommonResponse(CommonResponse.fail,"이메일이 없습니다");

        User user2 = userMapper.getByEmail(user.getEmail());
        if(user2 != null) {
            if (user.getPassword().equals(user2.getPassword())) {
                user.setPassword(null);
                return new CommonResponse(user, "로그인에 성공하였슴니다.");
            }
        }
        return new CommonResponse(CommonResponse.fail, "패스워드가 틀렸슴니다.");
    }
}
