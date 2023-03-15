package com.spring.openapi.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenApiDTO { // 데이터 담지 않고 오직 전달하는 목적으로 쓰이는 클래스 -> DTO
	private String siteName;
	private String method;
	private String accept;
	private String contentType;
}
