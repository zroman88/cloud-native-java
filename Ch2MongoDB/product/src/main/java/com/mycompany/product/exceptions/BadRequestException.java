package com.mycompany.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author roman.zeylikovich - Project cloud-native-java
 */
public class BadRequestException extends RuntimeException {
    public static final int ID_NOT_FOUND = 1;
    private static final long serialVersionUID = 1L;
    int errCode;

    public BadRequestException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    @ExceptionHandler(BadRequestException.class)
    void handleBadRequests(BadRequestException bre, HttpServletResponse response) throws IOException {
        int respCode = (bre.errCode == BadRequestException.ID_NOT_FOUND) ? HttpStatus.NOT_FOUND.value() : HttpStatus.BAD_REQUEST.value();
        response.sendError(respCode, bre.errCode + ":" + bre.getMessage());
    }

}
