package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontrado extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	
	public RecursoNoEncontrado(String resourceName, String fieldName, Object fieldValue) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	@Override
	public String toString() {
		return "RecursoNoEncontrado [resourceName=" + resourceName + ", fieldName=" + fieldName + ", fieldValue="
				+ fieldValue + "]";
	}


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public Object getFieldValue() {
		return fieldValue;
	}


	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}


	
	
	

}
