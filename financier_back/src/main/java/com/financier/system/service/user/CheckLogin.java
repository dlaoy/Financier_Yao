package com.financier.system.service.user;

import cn.hutool.crypto.digest.DigestUtil;
import com.financier.system.entity.domain.User;
import com.financier.system.mappers.user.UserMapper;
import com.financier.system.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author enrace
 */
@Service
public class CheckLogin implements Check {

    @Autowired
    private UserMapper userMapper;

    private Long task = 0L;

    @Override
    public HashMap<String, Integer> checkLogin(HashMap<String,String> params, HttpSession session){
        HashMap<String,Integer> result = new HashMap<>();
        result.put("loginState",401);
        if("".equals(params.get("userName")) || "".equals(params.get("password"))){
            return result;
        }
        User user = userMapper.queryUser(params.get("userName"));
        if(user != null && params.get("password").equals(
                DigestUtil.md5Hex(user.getPasswd()+"22ba2ce7e5203e6e885b8fc68a020851"))
        ) {
            result.put("loginState",200);
            SessionUtil.addSession(session,task++);
        }
        return result;
    }

}
