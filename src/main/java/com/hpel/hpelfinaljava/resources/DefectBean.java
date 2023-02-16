package com.hpel.hpelfinaljava.resources;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DefectBean {
	
	@NotNull(message = "The inspectionId must be a number")
	private Long inspectionId;
	
	@NotNull(message = "The partId must be a number")
	private Long partId;
	
	@NotBlank(message = "The status ins neccesary")
	@Size(max = 10)
	@NotNull
	private String status;
	
	@Size(max = 120,message = "Comments section only has 120 characters")
	private String comments;
	
	@NotNull(message = "The defect needs a valid repairDate")
	private LocalDate repairedDate;
	
	

	public DefectBean() {
		super();
	}

	public DefectBean(@NotBlank(message = "The inspectionId must be a number") Long inspectionId,
			@NotBlank(message = "The partId must be a number") Long partId,
			@NotBlank(message = "The status ins neccesary") @Size(max = 10) @NotNull String status,
			@Size(max = 120, message = "Comments section only has 120 characters") String comments,
			@NotBlank(message = "The defect needs a valid repairDate") LocalDate repairedDate) {
		super();
		this.inspectionId = inspectionId;
		this.partId = partId;
		this.status = status;
		this.comments = comments;
		this.repairedDate = repairedDate;
	}

	public Long getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(Long inspectionId) {
		this.inspectionId = inspectionId;
	}

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
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

	public LocalDate getRepairedDate() {
		return repairedDate;
	}

	public void setRepairedDate(LocalDate repairedDate) {
		this.repairedDate = repairedDate;
	}
	
	
}
