package com.financier.system.service.user;

import cn.hutool.crypto.digest.DigestUtil;
import com.financier.system.entity.domain.User;
import com.financier.system.mappers.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

/**
 * @author enrace
 */
@Service
public class CheckLogin implements Check {

    @Autowired
    private UserMapper userMapper;

    @Override
    public HashMap<String, Integer> checkLogin(HashMap<String,String> params){
        User user = userMapper.queryUser(params.get("userName"));
        HashMap<String,Integer> result = new HashMap<>();
        result.put("loginState",401);
//        System.out.println( DigestUtil.md5Hex(user.getPasswd()+"22ba2ce7e5203e6e885b8fc68a020851")); //del
        if(user != null && params.get("password").equals(
                DigestUtil.md5Hex(user.getPasswd()+"22ba2ce7e5203e6e885b8fc68a020851"))
        ) {
            result.put("loginState",200);
        }
        return result;
    }

}
