package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication // @ComponentScan(컨테이너가 자동으로 찾아 인스턴스 만들어줌)을 포함함
@EnableAspectJAutoProxy(proxyTargetClass = true) // AOP 추가 설정
public class DevProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevProjectApplication.class, args);
	}

}
