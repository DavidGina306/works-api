package com.orderworks.oswork.domain.execption;

public class WorkExecption	extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public WorkExecption(String message) {
		super(message);
	}
}
