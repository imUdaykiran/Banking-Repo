package com.uday.banking_app.Exceptions;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,String message,String details,String errorCode) {
}
