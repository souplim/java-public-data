package com.spring.client.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.client.reply.service.ReplyService;
import com.spring.client.reply.vo.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/***************************************************************************************
 * ���� : REST(Representational State Transfer)�� ���� 
 *      �ϳ��� URI�� �ϳ��� ������ ���ҽ��� ��ǥ�ϵ��� ����ȴٴ� �����̴�. 
 *      �� REST����� Ư�� URL�� �ݵ�� �׿� �����ϴ� ������ ��ü��� ���� �ǹ��ϴ� ����̴�. 
 *      /member/join => GET(ȸ������ȭ��) /member/join => POST ===> ���� ���Ƶ� get/post �ٸ��� ok
 *      ���� ��� 'board/125'�� �Խù� �߿��� 125���̶�� ������ �ǹ̸� �������� �����ϰ�, 
 *      �̿� ���� ó���� GET, POST ��İ� ���� �߰����� ������ ���ؼ� �����Ѵ�.
 *      http://localhost:8080/board/boardDetail?b_num=4
 *      http://localhost:8080/board/4  => GET
 *      
 *      http://localhost:8080/board/boardDelete?b_num=4 
 *      http://localhost:8080/board/4  => DELETE
 *      
 *      => url ���� �� �޼��� ���(GET��ȸ, POST�Է�, PUT����, DELETE����)���� �ĺ�!
 *      
 *      �ְ�޴� �ڿ�(Resource)�� �̸��� ����(mapping)�ϰ� URI�� ����� HTTP �޼���(GET, POST, PUT, DELETE)�� 
 *      ���� �ش� �ڿ��� ���¸� �ְ� �޴� ���� �ǹ�.
 ***************************************************************************************/

/***************************************************************************************
 * ���� : @RestController (@Controller + @ResponesBody)
 * Controller�� REST ����� ó���ϱ� ���� ������ ���. (������ Ư���� JSP�� ���� �並 ����� 
 * ���� ���� ������ �ƴ� REST ����� ������ ó���� ���ؼ� ����ϴ�(������ ��ü�� ��ȯ) ������̼��̴�.
 * @ResponesBody: �Ϲ����� JSP�� ���� ��� ���޵Ǵ� �� �ƴ϶� ������ ��ü�� �����ϱ� ���� �뵵�̴�.
 * @PathVariable: URL ��ο� �ִ� ���� �Ķ���ͷ� �����Ϸ��� �� �� ����Ѵ�.
 * http://localhost:8080/board/4 => 4 ���� �� ���
 * name=value&name1=value1
 * @RequestBody: JSON �����͸� ���ϴ� Ÿ��(VO)���� ���ε� ó���Ѵ�.{name:value} => name�� VO�� �ʵ������
 ***************************************************************************************/
@RestController // ȭ�� ��ȯ�� �ϳ��� ���� �����͸� �޾ƿ� ���̱� ������ �� ������̼� ����
@RequestMapping(value="/replies")
@Log4j
public class ReplyController {
	
	@Setter(onMethod_ = @Autowired) // �ܺο��� ���� �ν��Ͻ� ����
	private ReplyService replyService;
	
	/***************************************************************************************
	 * ��� �۸�� �����ϱ�
	 * @return List<ReplyVO>
	 * ����: @PathVariable�� URI�� ��ο��� ���ϴ� �����͸� �����ϴ� �뵵�� ������̼�
	 * ���� ���� Ÿ���� XML�̳� JSON���� ��ȯ�� ���� produces �Ӽ��� ����Ѵ�.
	 * produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	 * ���� ��û URL : http://localhoast:8080/replies/all/�Խ��Ǳ۹�ȣ
	 * ���� ��û URL : http://localhost:8080/replies/replyList?b_num=�Խ��Ǳ۹�ȣ
	 * ResponseEntity�� �����ڰ� ���� ��� �����Ϳ� HTTP ���� �ڵ�(200, 404, 500...)�� ������ �� �ִ� Ŭ����
	 ***************************************************************************************/
	/* @GetMapping(value="/all/{b_num}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> replyList(@PathVariable("b_num") Integer b_num){
		log.info("list ȣ�� ����");
		
		ResponseEntity<List<ReplyVO>> entity = null;
		entity = new ResponseEntity<>(replyService.replyList(b_num), HttpStatus.OK);
		return entity;
	} */
	
	@GetMapping(value="/all/{b_num}"/*�Խ��Ǳ۹�ȣ*/, produces=MediaType.APPLICATION_JSON_VALUE) // ������ ���� Ÿ�� JSON
	public List<ReplyVO> replyList(@PathVariable("b_num") Integer b_num){ // VO�� List�� ��� JSON���� ��ȯ
		log.info("list ȣ�� ����");
		
		List<ReplyVO> entity = null;
		entity = replyService.replyList(b_num); // URI���� �Խñ� ��ȣ ������ �Խñۿ� �ش��ϴ� ��� �ҷ�����
		return entity;
	} 

	/***************************************************************************************
	 * ��� �۾��� �����ϱ�
	 * @return String
	 * ���� : @RequestBody : JSON �����͸� ���ϴ� Ÿ��(VO)���� ���ε� ó���Ѵ�.{name:value}
	 * 		 consumes �Ӽ��� �̿��ϸ� ����ڰ� Request body�� ��� Ÿ���� ������ �� ������
	 * 		 ��û�� ����� �ݵ�� application/json�� �����ؾ� �Ѵ�.
	 * 		 produces �Ӽ��� �߰��ϰ� dataType�� �����ϸ� �ش� ������Ÿ�����θ� ����ڿ��� �����ϰڴٴ� �ǹ̷� �ؼ��ϸ� �ȴ�.
	 * ���� ��û URL : http://localhost:8080/replies/replyInsert
	 **************************************************************************************
	@PostMapping(value="/replyInsert", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replyInsert(@RequestBody ReplyVO rvo){
		log.info("replyInsert ȣ�� ����");
		log.info("ReplyVO : "+rvo);
		int result = 0;
		
		result = replyService.replyInsert(rvo);
		// result���� 1�� ��� "SUCCESS" ���ڿ� 200�� �����ڵ带 �����ϰ�, 1�� �ƴ� ��� ������ �����ڵ�(500) ����
		return (result==1) ? new ResponseEntity<String>("SUCCESS", HttpStatus.OK) : 
							 new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	} */
	
	@PostMapping(value="/replyInsert", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public String replyInsert(@RequestBody ReplyVO rvo) { // json ����{b_num:1, r_name:"ȫ�浿",...}�� �޾ƿ� �����Ϳ��� VO�� �Ҵ�
		log.info("replyInsert ȣ�� ����");
		log.info("ReplyVO : "+rvo);
		int result = 0;
		
		result = replyService.replyInsert(rvo);
		return (result==1) ? "SUCCESS" : "FAILURE";
	}
	
	/***************************************************************************************
	 * ��� ��й�ȣ Ȯ��
	 * @return String
	 * ���� : ��й�ȣ ��ġ �� 1, ��й�ȣ ��ġ���� ���� �� 0 ��ȯ
	 * ���� ��û URL : http://localhost:8080/replies/pwdConfirm
	 * @ResponseBody ������� �ʾƵ� ��(@RestController ���� ���)
	 *************************************************************************************
	@RequestMapping(value="/pwdConfirm", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> pwdConfirm(@ModelAttribute ReplyVO rvo){
		log.info("pwdConfirm ȣ�� ����");
		
		ResponseEntity<String> entity = null;
		int result = 0;
		
		result = replyService.pwdConfirm(rvo);
		entity = new ResponseEntity<String>(String.valueOf(result), HttpStatus.OK);
		return entity;
	} */
	
	@RequestMapping(value="/pwdConfirm", produces = MediaType.TEXT_PLAIN_VALUE)
	public String pwdConfirm(@ModelAttribute ReplyVO rvo){
		log.info("pwdConfirm ȣ�� ����");
		
		int result = 0;
		result = replyService.pwdConfirm(rvo);
		return String.valueOf(result); // int�� ��ȯ�� �� �������� �� �־ String���� ����ȯ
	}
	
	/***************************************************************************************
	 * ��� ���� �����ϱ�
	 * @retrun
	 * ���� : REST ��Ŀ��� UPDATE �۾��� PUT, PATCH ����� �̿��ؼ� ó��.
	 * 		 ��ü �����͸� �����ϴ� ��쿡�� PUT�� �̿��ϰ�,
	 * 		 �Ϻ��� �����͸� �����ϴ� ��쿡�� PATCH�� �̿�.
	 * ���� ��û URL : http://localhost:8080/replies/��۹�ȣ
	 ***************************************************************************************
	@RequestMapping(value="/{r_num}", method= {RequestMethod.PUT, RequestMethod.PATCH}, consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	@PutMapping(value="/{r_num}", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replyUpdate(@PathVariable("r_num") Integer r_num, @RequestBody ReplyVO rvo){
		log.info("replyUpdate ȣ�� ����");
		
		rvo.setR_num(r_num);
		int result = replyService.replyUpdate(rvo);
		return result == 1 ? new ResponseEntity<String>("SUCCESS", HttpStatus.OK) : 
							 new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	} */
	
	@PutMapping(value="/{r_num}", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	public String replyUpdate(@PathVariable("r_num") int r_num, @RequestBody ReplyVO rvo) { // @RequestBody -> Ŭ���̾�Ʈ�κ��� ��û�޾ƿ� �����Ͱ� json
		log.info("replyUpdate ȣ�� ����");
		
		rvo.setR_num(r_num);
		int result = replyService.replyUpdate(rvo);
		return (result == 1) ? "SUCCESS" : "FAILURE";
	}
	
	/***************************************************************************************
	 * ��� ���� �����ϱ�
	 * @return
	 * ���� : REST ��Ŀ��� ���� �۾��� DELETE ����� �̿��ؼ� ó��
	 * ���� ��û URL : http://localhost:8080/replies/��۹�ȣ
	 ***************************************************************************************/
	// @RequestMapping(value="/{r_num}", method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
	
	
	@DeleteMapping(value="/{r_num}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String replyDelete(@PathVariable("r_num") int r_num){
		log.info("replyDelete ȣ�� ����");
		log.info("r_num = "+r_num);
		
		int result = replyService.replyDelete(r_num);
		return (result==1) ? "SUCCESS" : "FAILURE";
	}
}
