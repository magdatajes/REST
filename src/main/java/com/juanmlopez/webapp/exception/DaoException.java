package com.juanmlopez.webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find entity with id.")
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

}
