package com.hpel.hpelfinaljava.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Inspection")
public class Inspection {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "vehicleId")
	@NotNull(message = "vehicleId cannot be null")
	private Long vehicleId;
	
	@Column(name = "driverId")
	@NotNull(message = "driverId cannot be null")
	private Long driverId;
	
	@Column(name = "comments")
	@Size(max = 120,message = "Comments field can only has 120 characters")
	private String comments;
	
	@Column(name = "createdDate")
	private LocalDate createdDate;
	
    @OneToMany(mappedBy="id", orphanRemoval = false)
    @JsonIgnore
    private List<Defect> defects;
    
    

	public Inspection() {
		super();
		this.createdDate = LocalDate.now();
	}

	public Inspection(Long id, @NotBlank(message = "The vehicleId cannot be empty") @NotNull Long vehicleId,
			@NotBlank(message = "The driverId cannot be empty") @NotNull Long driverId,
			@Size(max = 120, message = "Comments field can only has 120 characters") @NotNull String comments,
			@NotNull LocalDate createdDate) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.driverId = driverId;
		this.comments = comments;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
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

	

}
