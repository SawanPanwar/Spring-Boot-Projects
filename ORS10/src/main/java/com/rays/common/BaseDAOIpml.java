package com.rays.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDAOIpml<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	public EntityManager entityManager;

	public long add(T dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(T dto) {
		entityManager.merge(dto);
	}

	public void delete(T dto) {
		entityManager.remove(dto);
	}

}
