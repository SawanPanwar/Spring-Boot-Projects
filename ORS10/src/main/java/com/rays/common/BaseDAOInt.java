package com.rays.common;

public interface BaseDAOInt<T extends BaseDTO> {

	public long add(T dto);
	
	public void update(T dto);
	
	public void delete(T dto);

}
