package br.com.jezreelmoraes.flowboard.infra.exception;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private final int status;
    private final String error;
    private final String message;
    private final String code;
    private final Instant timestamp;
    private final List<FieldError> fields;

    @Getter
    @Builder
    public static class FieldError {
        private final String field;
        private final String message;
    }

    public static ErrorResponse of(int status, String error, String message, String code) {
        return ErrorResponse.builder()
            .status(status)
            .error(error)
            .message(message)
            .code(code)
            .timestamp(Instant.now())
            .build();
    }

    public static ErrorResponse of(int status, String error, String message, String code, List<FieldError> fields) {
        return ErrorResponse.builder()
            .status(status)
            .error(error)
            .message(message)
            .code(code)
            .timestamp(Instant.now())
            .fields(fields)
            .build();
    }
}
