package com.example2.example2.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String message;
    private Integer code;
    private LocalDateTime timestamp;
    private String path;
    private String errorId;


}
