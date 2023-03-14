package com.boot.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Setter
// @Getter
// @ToString
@NoArgsConstructor // �Ű����� �ִ� ������ ��������� �⺻������ �� ��������� ������ ���� ����
@AllArgsConstructor
@Data
public class SampleDTO {
	private String name;
	private int age;
}
