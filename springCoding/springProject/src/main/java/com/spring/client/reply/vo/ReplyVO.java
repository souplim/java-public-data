package com.spring.client.reply.vo;


import com.spring.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ReplyVO extends CommonVO {
	
	private int r_num = 0; 			// ´ñ±Û ¹øÈ£	
	private int b_num = 0; 			// °Ô½ÃÆÇ ±Û¹øÈ£
	private String r_name = ""; 	// ´ñ±Û ÀÛ¼ºÀÚ
	private String r_content = ""; 	// ´ñ±Û ³»¿ë
	private String r_date = ""; 	// ´ñ±Û ³¯Â¥
	private String r_pwd = ""; 		// ´ñ±Û ºñ¹Ð¹øÈ£
}
