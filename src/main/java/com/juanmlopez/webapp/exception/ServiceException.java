package com.juanmlopez.webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are violated.")
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
        super();
    }

}
