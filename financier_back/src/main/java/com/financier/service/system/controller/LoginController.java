package com.financier.service.system.controller;

import com.financier.service.system.entity.domain.User;
import com.financier.service.system.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Test my Controller.
 * It will delete by finished.
 * @author enrace
 */
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/loginUser",method = RequestMethod.POST)
    public HashMap queryUser(@RequestBody HashMap<String,String> params){
        User user = userMapper.queryUser(params.get("userName"));
        HashMap<String,Integer> result = new HashMap<>();
        result.put("loginState",401);
        if(user != null && params.get("password").equals(user.getPasswd())) {
            result.put("loginState",200);
        }
        return result;
    }
}
