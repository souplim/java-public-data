package com.spring.client.board.vo;

import org.springframework.web.multipart.MultipartFile;

import com.spring.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/* equals�� hashCode �޼��� �ڵ� ���� �� �θ� Ŭ������ �ʵ���� �������� �� ������ ���ؼ�
 * callSuper = true �� �����ϸ� �θ� Ŭ���� �ʵ尪�鵵 �������� üũ�ϸ�,
 * callSuper = false �� ����(�⺻��)�ϸ� �ڽ� Ŭ������ �ʵ尪�鸸 �����
 * */

@Data
@EqualsAndHashCode(callSuper=false)
public class BoardVO extends CommonVO {
	
	// �ʱⰪ ����
	private int b_num = 0;			// �۹�ȣ
	private String b_name = "";		// �ۼ���
	private String b_title = "";	// ����
	private String b_content = "";	// ����
	private String b_date;			// �ۼ���
	private String b_pwd = "";		// ��й�ȣ
	private int readcnt = 0;		// �Խñ� ��ȸ��
	private int r_cnt = 0;			// ��� ����
	
	private MultipartFile file; 	// ���� ���ε带 ���� �ʵ� - Ŭ���̾�Ʈ�� �������� ���� ��ü�� ��ü�� �ޱ� ����
	private String b_thumb = "";	// ���� ������ ������ ����� �̹��� ���ϸ�
	private String b_file = ""; 	// ���� ������ ������ ���ϸ�
}
