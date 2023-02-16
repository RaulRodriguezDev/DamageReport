package com.hpel.hpelfinaljava.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpel.hpelfinaljava.model.Inspection;
import com.hpel.hpelfinaljava.repository.InspectionRepository;
import com.hpel.hpelfinaljava.service.InspectionService;

@Service
public class InspectionServImpl implements InspectionService{
	
	@Autowired
	private InspectionRepository inspectionRepository;

	@Override
	public Inspection post(Inspection inspection) {
		
		Inspection inspectionInDb = new Inspection();
		
		inspectionInDb.setId(inspection.getId());
		inspectionInDb.setComments(inspection.getComments());
		inspectionInDb.setDriverId(inspection.getDriverId());
		inspectionInDb.setVehicleId(inspection.getVehicleId());
		
		return inspectionRepository.save(inspectionInDb);

	}

	@Override
	public List<Inspection> getAll() {
		
		return inspectionRepository.findAll();
	}

	@Override
	public Inspection getById(Long id) {
		
		Optional<Inspection> inspectionOptional = inspectionRepository.findById(id);
		
		Inspection inspection = inspectionOptional.get();
		
		return inspection;

	}

	@Override
	public Inspection put(Inspection inspection, Long id) {
		
		Optional<Inspection> inspectionOptional = inspectionRepository.findById(id);
		
		Inspection inspectionInDb = inspectionOptional.get();
		
		inspectionInDb.setComments(inspection.getComments());
		inspectionInDb.setDriverId(inspection.getDriverId());
		inspectionInDb.setVehicleId(inspection.getVehicleId());
		
		inspectionRepository.save(inspectionInDb);
		
		return inspectionInDb;
		

	}

	@Override
	public Inspection delete(Long id) {
		
		Optional<Inspection> inspectionOptional = inspectionRepository.findById(id);
		
		Inspection inspectionInDb = inspectionOptional.get();
		
		inspectionRepository.deleteById(id);
		
		return inspectionInDb;
		
	}

}
