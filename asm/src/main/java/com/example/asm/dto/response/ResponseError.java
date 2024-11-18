package com.example.asm.dto.response;

public class ResponseError extends ResponData{
    public ResponseError(int status, String messenge) {
        super(status, messenge);
    }
}
