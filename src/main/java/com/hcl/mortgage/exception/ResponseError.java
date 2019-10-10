package com.hcl.mortgage.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private int statusCode;

	public ResponseError(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;

	}

}
