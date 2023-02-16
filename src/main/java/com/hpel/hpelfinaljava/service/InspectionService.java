package com.hpel.hpelfinaljava.service;

import java.util.List;

import com.hpel.hpelfinaljava.model.Inspection;

public interface InspectionService {
	
	public Inspection post(Inspection inspection);
	
	public List<Inspection> getAll();
	
	public Inspection getById(Long id);
	
	public Inspection put(Inspection inspection,Long id);
	
	public Inspection delete(Long id);

}
