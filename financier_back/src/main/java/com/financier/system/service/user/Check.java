package com.financier.system.service.user;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author enrace
 */
public interface Check {
    /**
     *
     * @param params (HashMap)
     * @return HashMap
     */
    HashMap<String,Integer> checkLogin(HashMap<String,String> params, HttpSession session);
}
