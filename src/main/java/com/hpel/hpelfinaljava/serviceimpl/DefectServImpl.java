package com.hpel.hpelfinaljava.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpel.hpelfinaljava.model.Defect;
import com.hpel.hpelfinaljava.model.Inspection;
import com.hpel.hpelfinaljava.model.Part;
import com.hpel.hpelfinaljava.repository.DefectRepository;
import com.hpel.hpelfinaljava.repository.InspectionRepository;
import com.hpel.hpelfinaljava.repository.PartRepository;
import com.hpel.hpelfinaljava.resources.DefectBean;
import com.hpel.hpelfinaljava.service.DefectService;

@Service
public class DefectServImpl implements DefectService{
	
	@Autowired
	private DefectRepository defectRepository;
	@Autowired
	private PartRepository partRepository;
	@Autowired
	private InspectionRepository inspectionRepository;

	@Override
	public Defect post(DefectBean defect) {
		
		Defect defectInDB = new Defect();
		
		Optional<Part> partOptional = partRepository.findById(defect.getPartId());
		
		Optional<Inspection> inspectionOptional = inspectionRepository.findById(defect.getInspectionId());
		
		defectInDB.setComments(defect.getComments());
		defectInDB.setInspectionId(inspectionOptional.get());
		defectInDB.setPartId(partOptional.get());
		defectInDB.setStatus(defect.getStatus());
		defectInDB.setRepairedDate(defect.getRepairedDate());
				
		return defectRepository.save(defectInDB);
		
	}

	@Override
	public List<Defect> getAll() {
		
		return defectRepository.findAll();
	}

	@Override
	public Defect getById(Long id) {
		
		Optional<Defect> defectOptional = defectRepository.findById(id);
		
		Defect defectInDb = defectOptional.get();
		
		return defectInDb;
	}

	@Override
	public Defect put(Defect defect, Long id) {
		
		Optional<Defect> defectOptional = defectRepository.findById(id);
		
		Defect defectInDb = defectOptional.get();
		
		defectInDb.setInspectionId(defect.getInspectionId());
		defectInDb.setPartId(defect.getPartId());
		defectInDb.setComments(defect.getComments());
		defectInDb.setCreatedDate(defect.getCreatedDate());
		defectInDb.setRepairedDate(defect.getCreatedDate());
		
		return defectInDb;

	}

	@Override
	public Defect delete(Long id) {
		
		Optional<Defect> defectOptional = defectRepository.findById(id);
		
		Defect defectInDb = defectOptional.get();
		
		defectRepository.deleteById(id);
		
		return defectInDb;
	}

}
