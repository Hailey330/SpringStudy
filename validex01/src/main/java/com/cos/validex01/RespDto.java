package com.cos.validex01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RespDto<T> {
	private int statusCode; // 1, 2, 3, 4, 5 - 나만의 규칙으로 인터페이스 정의해두기!
	private String msg;
	private T data;
}
