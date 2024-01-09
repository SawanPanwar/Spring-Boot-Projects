package com.rays.common;

public interface BaseServiceInt<T extends BaseDTO> {

	public long add(T dto);

	public void update(T dto);

	public T findById(long pk);

	public void delete(long id);

}
