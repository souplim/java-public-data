package com.spring.common.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
public class FileUploadUtil { // Util Ŭ���� -> �������� ��� Ŭ���� ���

	/***********************************************************
	 * ���� ���ε��� ���� ����
	 **********************************************************/
	public static void makeDir(String docRoot) {
		File fileDir = new File(docRoot);
		if(fileDir.exists()) // ������ �����ϸ� return(����)
			return;
		fileDir.mkdirs();
	}
	
	/***********************************************************
	 * ���� ���ε� �޼���
	 * ���ϸ� �ߺ��� �ذ���
	 * 1. System.currentTimeMillis()�� ����ϰų�(�����Ͻú��� ���) 2. UUID ���
	 * UUID�� 128��Ʈ�� ��
	 * ǥ�� ���Ŀ��� UUID�� 32���� 16������ ǥ���Ǹ� �� 36�� ����(32�� ���ڿ� 4���� ������)�� ��
	 * 8-4-4-4-12��� 5�� �׷��� ���������� �����Ѵ�. �̸� �׸� ������ ����.
	 * �� �� UUID.randomUUID().toString()�� �̿��ؼ� ��´�.
	 * 50e8400-e29b-41d4-a716-446655440000 (replace�� ������ ���� ����)
	 **********************************************************/
	public static String fileUpload(MultipartFile file, String fileName) throws IOException {
		// MultipartFile -> ���� ��ü ���޹��� fileName -> ��� �� ��������(board..) ����ؼ� ���� �̸� ����
		
		log.info("fileUpload ȣ�� ����");
		
		String real_name = null;
		// MultipartFile Ŭ������ getFile() �޼���� Ŭ���̾�Ʈ�� ���ε��� ����
		String org_name = file.getOriginalFilename(); // ex) a.gif
		log.info("���ε� ���ϸ� :" + org_name);
		
		// ���ϸ� ����(�ߺ����� �ʰ�)
		if(org_name != null && (!org_name.equals(""))) {
			real_name = fileName +"_"+ System.currentTimeMillis()+"_"+ org_name; // ������ ���� �̸� ex) board_000000_a.gif
			String docRoot = "C://uploadStorage//"+fileName; // C://uploadStorage//board
			makeDir(docRoot); // ���� ����
			
			File fileAdd = new File(docRoot + "/" + real_name); // C://uploadStorage//board/board_000000_a.gif
			log.info("���ε��� ����(fileAdd) : " + fileAdd);
			
			file.transferTo(fileAdd); // �� �޼��忡 ���� ���� ��ο� ���������� File�� ������
		}
		return real_name; // ������ ����� ���ϸ� ��ȯ(board_1658205347977_cat.jpg)
	}
	
	/***********************************************************
	 * ���� ���� �޼��� - �Խñ� �����ϸ� ���ϵ� ���� ���� �ǰ� �ؾ� ��
	 * ��� �� ���ϸ�: board/board_1658205347977_cat.jpg
	 * Thumbnail ��� �� ���ϸ�: board/thumbnail/thumbnail_board_1658205347977_cat.jpg
	 **********************************************************/
	public static void fileDelete(String fileName) throws IOException { // fileName = thumbnail_board_1658205347977_cat.jpg
		log.info("fileDelete ȣ�� ����");
		boolean result = false;
		String startDirName = "", docRoot = "";
		String dirName = fileName.substring(0, fileName.indexOf("_")); // dirName = thumbnail
		
		if(dirName.equals("thumbnail")) {
			startDirName = fileName.substring(dirName.length()+1, fileName.indexOf("_", dirName.length()+1)); // board
			//						thumbnail�� ���̼�+1���� �����Ͽ�, thumbnail�� ���̼�+1 �������� �����Ͽ� ������ _ ������ substring
			docRoot = "C://uploadStorage//"+startDirName+"//"+dirName; // C://uploadStorage//board//thumbnail
		} else {
			docRoot = "C://uploadStorage//"+dirName; // C://uploadStorage//board
		}
		
		File fileDelete = new File(docRoot+"/"+fileName); // C://uploadStorage//board//thumbnail/thumbnail_board_1658205347977_cat.jpg
		
		if(fileDelete.exists() && fileDelete.isFile()) {
			result = fileDelete.delete();
		}
		log.info("���� ���� ����(true/false) : " + result);
	}
	
	/***********************************************************
	 * ���� Thumbnail ���� �޼���
	 * ū �̹��� ���̸� �ػ� ���� �� ������ �ƿ� ���� ũ�� �ٲ�
	 * Thumbnail ��� �� ���ϸ�: thumbnail/thumbnail_board_1658205347977_cat.jpg (Ȱ�뵵 ��� �ؼ� ��Ī �ֱ�)
	 **********************************************************/
	public static String makeThumbnail(String fileName) throws Exception { // �������� fileName = board_1658205347977_cat.jpg
		String dirName = fileName.substring(0,fileName.indexOf("_")); // ���� �̸� ���� dirName = board
		// �̹����� �����ϴ� ���� ����
		String imgPath = "C://uploadStorage//"+dirName;
		// ����� ������ ���� ���(������ ��ġ: C:\...)
		File fileAdd = new File(imgPath, fileName); // ���� ��ü ����� C://uploadStorage//board//board_1658205347977_cat.jpg
		log.info("���� �̹��� ����(fileAdd) : " + fileAdd);
		
		BufferedImage sourceImg = ImageIO.read(fileAdd); // fileAdd�� �ش��ϴ� �̹��� ������ �о�ͼ� �����ͷ� ����
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 133); // ũ�⸦ �����Ͽ� �̹��� ������ ����
									// resize(���[BufferedImage Ÿ��]=�����̹���, ��������(���μ��κ���), ���� �Ǵ� �ʺ�, ũ��)
		
		String thumbnailName = "thumbnail_"+fileName; // thumbnail_board_1658205347977_cat.jpg
		String docRoot = imgPath+"/thumbnail"; // ����� ���� ���� C://uploadStorage//board//thumbnail
		makeDir(docRoot);
		
		File newFile = new File(docRoot, thumbnailName); // C://uploadStorage//board//thumbnail_board_1658205347977_cat.jpg
		// ���ϸ�� Ȯ���ڸ� �����ؾ� ���� ����(���̺귯�� ���)
		log.info("���ε��� ����(newFile) : " +newFile);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1); // Ȯ����: jpg
		log.info("Ȯ����(formatName) : " +formatName);
		
		ImageIO.write(destImg, formatName, newFile); // ������ �̹��� �����͸� ������ ���Ͽ� ���� (�̹��� ������ ���� �̹���, Ȯ����, ���ϰ�ü)
		
		return thumbnailName; // ������ ����� ���ϸ� ��ȯ(thumbnail_board_1658205347977_cat.jpg)
	}
	
}
