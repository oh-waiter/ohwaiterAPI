package br.com.valhalla.ohwaiter.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String message;
	private String detaius;
	
	public ExceptionResponse(Date timestamp, String message, String detaius) {
		this.timestamp = timestamp;
		this.message = message;
		this.detaius = detaius;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetaius() {
		return detaius;
	}

	public void setDetaius(String detaius) {
		this.detaius = detaius;
	}
	
	
	
	

}
