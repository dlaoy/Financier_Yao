package com.financier.system.service.user;

import com.financier.system.entity.domain.User;
import com.financier.system.mappers.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CheckLogin {

    @Autowired
    private UserMapper userMapper;

    public HashMap<String, Integer> chekLogin(HashMap<String,String> params){
        User user = userMapper.queryUser(params.get("userName"));
        HashMap<String,Integer> result = new HashMap<>();
        result.put("loginState",401);
        if(user != null && params.get("password").equals(user.getPasswd())) {
            result.put("loginState",200);
        }
        return result;
    }

}
