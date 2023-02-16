package com.hpel.hpelfinaljava.service;

import java.util.List;

import com.hpel.hpelfinaljava.model.Defect;
import com.hpel.hpelfinaljava.resources.DefectBean;


public interface DefectService {
	
	public Defect post(DefectBean defect);
	
	public List<Defect> getAll();
	
	public Defect getById(Long id);
	
	public Defect put(Defect defect,Long id);
	
	public Defect delete(Long id);

}
