package com.security.demo2.mapper;

import com.security.demo2.model.Role;
import com.security.demo2.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select*from user where username=#{username}")
        User loadUserByUsername(String username);
    @Select({"select*from role r",
    "left join user_role ur",
    "on r.id=ur.rid",
    "where ur.uid=#{id}"})
    List<Role>getUserRolesById(Integer id);
}
