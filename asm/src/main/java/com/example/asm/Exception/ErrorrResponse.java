package com.example.asm.Exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class ErrorrResponse {
    private Date timestamp;
    private int status;
    private String path;
    private String error;
    private String masege;

}
