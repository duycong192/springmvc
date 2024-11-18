package com.example.asm.dto.response;

public class ResponData <T>{
    private int status;
    private String messenge;
    private T data;

    public ResponData(int status, String messenge) {
        this.status = status;
        this.messenge = messenge;
    }

    public ResponData(int status, String messenge, T data) {
        this.status = status;
        this.messenge = messenge;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessenge() {
        return messenge;
    }

    public T getData() {
        return data;
    }
}
