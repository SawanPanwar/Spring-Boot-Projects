package com.rays.dao;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOIpml;
import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl extends BaseDAOIpml<UserDTO> implements UserDAOInt {

}
