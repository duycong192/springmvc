package com.example.asm.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess extends ResponseEntity<ResponseSuccess.PayLoad> {
//put, patch, delete
    public ResponseSuccess(HttpStatusCode status, String message) {
        super(new PayLoad(status.value(), message), HttpStatus.OK);
    }
//get, post
    public ResponseSuccess(HttpStatusCode status, String message,Object data) {
        super(new PayLoad(status.value(), message,data), HttpStatus.OK);
    }


    public static class PayLoad {
        private final int status;
        private final String messege;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Object data;


        public PayLoad(int status, String messege) {
            this.status = status;
            this.messege = messege;
        }

        public PayLoad(int status, String messege, Object data) {
            this.status = status;
            this.messege = messege;
            this.data = data;
        }

        public int getStatus() {
            return status;
        }

        public String getMessege() {
            return messege;
        }

        public Object getData() {
            return data;
        }
    }
}
