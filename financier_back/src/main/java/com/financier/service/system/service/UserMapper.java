package com.financier.service.system.service;

import com.financier.service.system.entity.domain.User;

/**
 * @author enrace
 */
public interface UserMapper {
    User queryUser(String userName);
}
