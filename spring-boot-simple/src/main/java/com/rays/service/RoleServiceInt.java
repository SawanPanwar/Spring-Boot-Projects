package com.rays.service;

import java.util.List;

import com.rays.dto.RoleDTO;

public interface RoleServiceInt {
	
	public List search(RoleDTO dto, int pageNo, int pageSize);

}
