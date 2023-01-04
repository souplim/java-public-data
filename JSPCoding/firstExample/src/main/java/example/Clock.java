package example;

import java.text.SimpleDateFormat;
import java.util.Date;
/* 웹에서 클래스를 접근하기 위해서는 반드시 패키지 설정이 선행되어야 한다. */

public class Clock {
	
	public String now() {
		Date nowDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyy년 MM월 dd일 hh시 mm분 ss초");
		String formatTime = timeFormat.format(nowDate);
		
		return formatTime;
	}
}
