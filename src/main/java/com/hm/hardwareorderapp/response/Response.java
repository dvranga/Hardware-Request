package com.hm.hardwareorderapp.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {
	
	private int status;
	private String message;
	private Object data;

	public Response(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Response(int status, String message, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}


}
