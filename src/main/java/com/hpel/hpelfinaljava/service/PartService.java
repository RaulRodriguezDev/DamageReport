package com.hpel.hpelfinaljava.service;

import java.util.List;

import com.hpel.hpelfinaljava.model.Part;

public interface PartService {
	
	public Part post(Part part);
	
	public List<Part> getAll();
	
	public Part getById(Long id);
	
	public Part put(Part part,Long id);
	
	public Part delete(Long id);
}
