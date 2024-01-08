package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

}
