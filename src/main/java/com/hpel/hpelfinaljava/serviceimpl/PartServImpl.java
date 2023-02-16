package com.hpel.hpelfinaljava.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpel.hpelfinaljava.model.Part;
import com.hpel.hpelfinaljava.repository.PartRepository;
import com.hpel.hpelfinaljava.service.PartService;

@Service
public class PartServImpl implements PartService{
	
	@Autowired
	private PartRepository partRepository;

	@Override
	public Part post(Part part) {
		
		return partRepository.save(part);
	}

	@Override
	public List<Part> getAll() {
		
		return partRepository.findAll();
	}

	@Override
	public Part getById(Long id) {
		
		Optional<Part> partOptional = partRepository.findById(id);
		
		Part partInDb = partOptional.get();
		
		return partInDb;
	}

	@Override
	public Part put(Part part, Long id) {
		
		Optional<Part> partOptional = partRepository.findById(id);
		
		Part partInDb = partOptional.get();
		
		partInDb.setName(part.getName());
		
		partRepository.save(partInDb);
		
		return partInDb;

	}

	@Override
	public Part delete(Long id) {
		
		Optional<Part> partOptional = partRepository.findById(id);
		
		Part partInDb = partOptional.get();
		
		partRepository.deleteById(id);
		
		return partInDb;

	}

}
