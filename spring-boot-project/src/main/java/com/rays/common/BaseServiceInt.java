package com.rays.common;

import java.util.List;

public interface BaseServiceInt<T extends BaseDTO> {

	public long add(T dto);

	public void update(T dto);

	public T findById(long pk);

	public void delete(long id);

	public long save(T dto);
	
	public List search(T dto, int pageNo, int pageSize);

}
