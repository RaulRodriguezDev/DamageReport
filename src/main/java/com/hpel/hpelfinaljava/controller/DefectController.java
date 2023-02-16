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

import com.hpel.hpelfinaljava.model.Defect;
import com.hpel.hpelfinaljava.resources.DefectBean;
import com.hpel.hpelfinaljava.service.DefectService;

@RestController
public class DefectController {
	
	@Autowired
	private DefectService defectService;
	
	@PostMapping("/defects")
	public ResponseEntity<Defect> post(@Valid @RequestBody DefectBean defect)
	{
		Defect savedDefect = defectService.post(defect);
		return  new ResponseEntity<>(savedDefect,HttpStatus.CREATED);
	}
	
	@GetMapping("/defects")
	public ResponseEntity<List<Defect>> getAll(){
				
		return new ResponseEntity<>(defectService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/defects/{id}")
	public ResponseEntity<Defect> get(@PathVariable Long id)
	{
		return new ResponseEntity<>(defectService.getById(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/defects/{id}")
	public ResponseEntity<Defect> put(@Valid @RequestBody Defect defect,@PathVariable Long id){
		
		Defect updatedDefect = defectService.put(defect, id);
		
		return new ResponseEntity<>(updatedDefect,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/defects/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		
		defectService.delete(id);
		
		return ResponseEntity.ok().body("The item was deleted");
	}
}
