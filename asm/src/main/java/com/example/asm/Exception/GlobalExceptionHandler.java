package com.example.asm.Exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorrResponse handlerValidation(Exception e, WebRequest webRequest){
        ErrorrResponse errorrResponse = new ErrorrResponse();
        errorrResponse.setTimestamp(new Date());
        errorrResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorrResponse.setPath(webRequest.getDescription(false).replace("uri=",""));


        String mesage = e.getMessage();

        if (e instanceof IllegalArgumentException){

            int fistIndex = mesage.lastIndexOf("[");
            int lastIndex = mesage.lastIndexOf("]");
            mesage = mesage.substring(fistIndex+1,lastIndex-1);

        }else{
            mesage.substring(mesage.indexOf(" "),1);
            errorrResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        errorrResponse.setMasege(mesage);
        return errorrResponse;
    }
}
