package com.spring.client.reply.vo;


import com.spring.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ReplyVO extends CommonVO {
	
	private int r_num = 0; 			// ��� ��ȣ	
	private int b_num = 0; 			// �Խ��� �۹�ȣ
	private String r_name = ""; 	// ��� �ۼ���
	private String r_content = ""; 	// ��� ����
	private String r_date = ""; 	// ��� ��¥
	private String r_pwd = ""; 		// ��� ��й�ȣ
}
