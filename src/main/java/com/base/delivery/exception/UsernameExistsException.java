package com.base.delivery.exception;

import com.base.delivery.exception.message.ErrorResponse;
import lombok.Getter;

@Getter
public class UsernameExistsException extends RuntimeException {

    private final ErrorResponse errorResponse;

    public UsernameExistsException(String message) {
        super(message);
        this.errorResponse = new ErrorResponse(message);
    }

}
