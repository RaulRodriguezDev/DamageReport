package com.hpel.hpelfinaljava.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hpel.hpelfinaljava.model.Inspection;
import com.hpel.hpelfinaljava.service.InspectionService;

@RestController
public class InspectionController {
	
	@Autowired
	private InspectionService inspectionService;
	
	@PostMapping("/inspections")
	public ResponseEntity<Inspection> post(@Valid @RequestBody Inspection inspection)
	{
		Inspection savedInspection = inspectionService.post(inspection);
		
		return  new ResponseEntity<>(savedInspection,HttpStatus.CREATED);
	}
	
	@GetMapping("/inspections")
	public ResponseEntity<List<Inspection>> getAll(){
				
		return new ResponseEntity<>(inspectionService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/inspections/{id}")
	public ResponseEntity<Inspection> get(@PathVariable Long id)
	{
		return new ResponseEntity<>(inspectionService.getById(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/inspections/{id}")
	public ResponseEntity<Inspection> put(@Valid @RequestBody Inspection inspection,@PathVariable Long id){
		
		Inspection updatedInspection = inspectionService.put(inspection, id);
		
		return new ResponseEntity<>(updatedInspection,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/inspections/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		
		inspectionService.delete(id);
		
		return ResponseEntity.ok().body("The item was deleted");
	}

}
