package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.UserDTO;

@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	public Class<UserDTO> getDTOClass() {
		return UserDTO.class;
	}

	@Override
	public List<Predicate> getWhereClause(CriteriaBuilder builder, Root qRoot, UserDTO dto) {

		List<Predicate> whereConditon = new ArrayList<Predicate>();

		if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
			whereConditon.add(builder.like(qRoot.get("firstName"), dto.getFirstName()));
		}

		return whereConditon;
	}

}
