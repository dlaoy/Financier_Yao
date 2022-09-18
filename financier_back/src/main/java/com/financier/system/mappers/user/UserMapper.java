package com.financier.system.mappers.user;

import com.financier.system.entity.domain.User;

/**
 * @author enrace
 */
public interface UserMapper {
    User queryUser(String userName);
}
