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

import com.hpel.hpelfinaljava.model.Part;
import com.hpel.hpelfinaljava.service.PartService;

@RestController
public class PartController {
	
	@Autowired
	private PartService partService;
	
	@PostMapping("/parts")
	public ResponseEntity<Part> post(@Valid @RequestBody Part part)
	{
		Part savedPart = partService.post(part);
		
		return  new ResponseEntity<>(savedPart,HttpStatus.CREATED);
	}
	
	@GetMapping("/parts")
	public ResponseEntity<List<Part>> getAll(){
				
		return new ResponseEntity<>(partService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/parts/{id}")
	public ResponseEntity<Object> get(@PathVariable Long id)
	{
		Part partInDb = partService.getById(id);
		
		try
		{
			if(partInDb!=null)
				return new ResponseEntity<>(partService.getById(id),HttpStatus.FOUND);
			
			return ResponseEntity.badRequest().body("The item has been removed or deleted");
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Searching request error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/parts/{id}")
	public ResponseEntity<Part> put(@Valid @RequestBody Part part,@PathVariable Long id){
		
		Part updatedPart = partService.put(part, id);
		
		return new ResponseEntity<>(updatedPart,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/parts/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		
		partService.delete(id);
		
		return ResponseEntity.ok().body("The item was deleted");
	}

}
