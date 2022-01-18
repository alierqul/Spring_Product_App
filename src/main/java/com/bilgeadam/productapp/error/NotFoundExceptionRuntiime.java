package com.bilgeadam.productapp.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptionRuntiime extends RuntimeException {


    public NotFoundExceptionRuntiime(String message) {
        super(message);

    }


    public NotFoundExceptionRuntiime(String message, Throwable cause) {
        super(message, cause);
    }

}
