package com.financier.system.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);

    public static void addSession(HttpSession session,Long sessionId){
        session.setAttribute("SESSION", sessionId);
    }
}
