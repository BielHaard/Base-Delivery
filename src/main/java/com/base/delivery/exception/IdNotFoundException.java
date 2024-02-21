package com.base.delivery.exception;

import com.base.delivery.exception.message.ErrorResponse;
import lombok.Getter;

@Getter
public class IdNotFoundException extends RuntimeException{

    private final ErrorResponse errorResponse;

    public IdNotFoundException(String message) {
        super(message);
        this.errorResponse = new ErrorResponse(message);
    }

}
