package com.example.BasicServer.errors;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;   // Describes the error
    private int status;       // HTTP status code
    private LocalDateTime timestamp; // When the error occurred

    public ErrorResponse(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now(); // Automatically sets the timestamp
    }

	public String getMessage() {
		return message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Error:"+"\n\t messge:"+this.message+"\n\tAt time: "+this.timestamp;
	}
}
