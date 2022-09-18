package com.financier.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.financier.system.service.user.CheckLogin;
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
    private CheckLogin chek;

    //    @RequestBody
    @RequestMapping(value="/loginUser",method = RequestMethod.POST)
    public HashMap<String,Integer> queryUser( HashMap<String,String> params){
        return chek.chekLogin(params);
    }
}
