package com.rays.common;

public interface BaseServiceInt<T extends BaseDTO> {

	public long add(T dto);

	public void update(T dto);

	public void delete(T dto);

	public long save(T dto);

}
