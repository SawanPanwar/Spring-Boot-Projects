package com.rays.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

	@Autowired
	public D baseDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(T dto) {
		long pk = baseDao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto) {
		baseDao.update(dto);
	}

	@Transactional(readOnly = true)
	public T findById(long pk) {
		T dto = baseDao.findByPk(pk);
		return dto;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		try {
			T dto = findById(id);
			baseDao.delete(dto);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

}
