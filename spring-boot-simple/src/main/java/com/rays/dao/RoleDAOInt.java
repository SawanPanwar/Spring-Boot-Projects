package com.rays.dao;

import java.util.List;

import com.rays.dto.RoleDTO;

public interface RoleDAOInt {

	public RoleDTO findByPk(long pk);

	public List search(RoleDTO dto, int pageNo, int pageSize);

}
