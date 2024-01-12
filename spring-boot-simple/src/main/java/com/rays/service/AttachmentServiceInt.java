package com.rays.service;

import com.rays.dto.AttachmentDTO;

public interface AttachmentServiceInt {

	public long add(AttachmentDTO dto);

	public void update(AttachmentDTO dto);

	public void delete(long dto);

	public AttachmentDTO findById(long pk);

	public long save(AttachmentDTO dto);

}
