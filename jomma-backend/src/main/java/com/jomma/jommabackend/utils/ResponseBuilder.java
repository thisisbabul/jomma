package com.jomma.jommabackend.utils;

import com.jomma.jommabackend.entity.Response;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@NoArgsConstructor
public class ResponseBuilder {

    public static Response getSuccessResponse(HttpStatus httpStatus, Object content, String message){
        return Response.builder()
                .timestamp(new Date().getTime())
                .statusCode(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .content(content)
                .build();
    }

    public static Response getFailResponse(HttpStatus httpStatus, String message) {
        return Response.builder()
                .timestamp(new Date().getTime())
                .statusCode(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .build();
    }
}
