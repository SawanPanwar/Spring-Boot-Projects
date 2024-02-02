package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

@Service
@Transactional
public class RoleServiceImpl implements RoleServiceInt {

	@Autowired
	public RoleDAOInt roleDao;

	@Transactional(readOnly = true)
	public List search(RoleDTO dto, int pageNo, int pageSize) {
		List list = roleDao.search(dto, pageNo, pageSize);
		return list;
	}

}
