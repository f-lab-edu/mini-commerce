package com.flab.commerce.web.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class Response {

	private HttpStatus status;

	private Integer code;

	private Object data;

	private String error;

	public static Response of() {
		return Response.builder()
				.status(HttpStatus.OK)
				.code(HttpStatus.OK.value())
				.data("")
				.build();
	}

	public static Response of(HttpStatus status) {
		return Response.builder()
				.status(status)
				.code(status.value())
				.build();
	}

	public Response addData(Object data) {
		this.data = data;
		return Response.builder()
				.data(this.data)
				.build();
	}
}
