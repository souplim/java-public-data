package com.spring.common.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDTO {
	private int startPage; // ȭ�鿡�� �������� �������� ���� ��ȣ
	private int endPage; // ȭ�鿡�� �������� �������� �� ��ȣ
	private boolean prev, next; // ������ �������� �̵��� ��ũ�� ǥ�� ����
	
	private int total;
	private CommonVO cvo;
	
	// CommonVO�� ��ӹ��� BoardVO ���� �� ����
	public PageDTO(CommonVO cvo, int total) { // CommonVO�� BoardVO ���� �� ����
		this.cvo = cvo;
		this.total = total;
		
		/* ����¡�� ����ȣ(endPage) ���ϱ�
		 * this.endPage = (int)(Math.ceil(��������ȣ/10.0)) * 10; */
		this.endPage = (int)(Math.ceil(cvo.getPageNum()/10.0)) * 10;
		
		/* ����¡�� ���۹�ȣ(startPage) ���ϱ� - ���۹�ȣ�� ������ �� ��ȣ���� 9�� ���ָ� �� */
		this.startPage = this.endPage - 9;
		
		/* �� ������ ���ϱ� */
		int realEnd = (int)(Math.ceil(total*1.0/cvo.getAmount()));
		
		if(realEnd< this.endPage)
			this.endPage = realEnd;
		
		/* ����(prev) ���ϱ�[����10��] - ������ ���� ���۹�ȣ�� 1���� ū ����� �����ϰ� ��(true) */
		this.prev = this.startPage > 1;
		
		/* ����(next) ���ϱ� */
		this.next = this.endPage < realEnd;
	}
}
