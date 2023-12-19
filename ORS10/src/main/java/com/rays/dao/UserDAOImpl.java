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

	public List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!(isEmptyString(dto.getFirstName()))) {

			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));

		}
		return whereCondition;
	}
}
