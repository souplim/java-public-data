package com.spring.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CommonVO {

	private int pageNum = 0; // ������ ��ȣ
	private int amount = 0; // �������� ������ ������ ��
	
	// ���� �˻� �� ����� �ʵ�(�˻����, �˻��ܾ�)
	private String search = "";
	private String keyword = "";
	
	// ������ ������ - ��¥ �˻� �� ����� �ʵ�(������, ������)
	private String start_date = "";
	private String end_date = "";
	
	public CommonVO() {
		this(1, 10); // �⺻ - 1 �������� 10�� ������
	}
	public CommonVO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}