package com.rays.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	public EntityManager entityManager;

	public abstract Class<T> getDTOClass();

	public long add(T dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(T dto) {
		entityManager.merge(dto);
	}

	public T findByPk(long pk) {
		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}

	public void delete(T dto) {
		entityManager.remove(dto);
	}

}
