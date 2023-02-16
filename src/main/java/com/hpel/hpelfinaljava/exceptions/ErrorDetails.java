package com.hpel.hpelfinaljava.exceptions;

import java.time.LocalDate;

public class ErrorDetails {
	
	private int errorsCount;
	private String status;
	private String message;
	private LocalDate timestamp;
	
	public ErrorDetails(int errorsCount, String status, String message, LocalDate timestamp) {
		super();
		this.errorsCount = errorsCount;
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public int getErrorsCount() {
		return errorsCount;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}
	
	

}
