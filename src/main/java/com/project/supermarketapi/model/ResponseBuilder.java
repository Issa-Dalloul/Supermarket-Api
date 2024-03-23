package com.project.supermarketapi.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {
	public static Response success(String message, Object object) {
		return new Response(0, message, object);
	}
	public static Response success(Object object) {
		return new Response(0, "OK", object);
	}

	public static Response failed() {
		return new Response(1, "Failed", null);
	}

	public static Response failed(String message) {
		return new Response(1, message, null);		
	}
}
