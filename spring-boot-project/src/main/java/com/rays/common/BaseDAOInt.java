package com.rays.common;

public interface BaseDAOInt<T extends BaseDTO> {

	public long add(T dto);

	public void update(T dto);

	public T findByPk(long pk);

	public void delete(T dto);
}
