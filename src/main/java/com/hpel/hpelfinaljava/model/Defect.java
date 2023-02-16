package com.hpel.hpelfinaljava.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "Defect")
public class Defect {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inspectionId")
	private Inspection inspectionId;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "partId")
	private Part partId;
	
	@Column(name = "status")
	@NotBlank(message = "The status field cannot be null")
	private String status;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "createdDate")
	@NotNull
	private LocalDate createdDate;
	
	@Column(name = "repairedDate")
	@NotNull(message = "repairDate cannot be empty")
	private LocalDate repairedDate;
	
	public Defect() {
		super();
		this.createdDate=LocalDate.now();
	}


	public Defect(Long id, Inspection inspectionId, Part partId,
			@NotNull @NotBlank(message = "status cannot be empty") String status, String comments,
			LocalDate createdDate, @NotBlank(message = "repairDate cannot be empty") LocalDate repairedDate) {
		super();
		this.id = id;
		this.inspectionId = inspectionId;
		this.partId = partId;
		this.status = status;
		this.comments = comments;
		this.createdDate = createdDate;
		this.repairedDate = repairedDate;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public Inspection getInspectionId() {
		return inspectionId;
	}





	public void setInspectionId(Inspection inspectionId) {
		this.inspectionId = inspectionId;
	}





	public Part getPartId() {
		return partId;
	}





	public void setPartId(Part partId) {
		this.partId = partId;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public String getComments() {
		return comments;
	}





	public void setComments(String comments) {
		this.comments = comments;
	}





	public LocalDate getCreatedDate() {
		return createdDate;
	}





	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}





	public LocalDate getRepairedDate() {
		return repairedDate;
	}





	public void setRepairedDate(LocalDate repairedDate) {
		this.repairedDate = repairedDate;
	}


	
	

}
