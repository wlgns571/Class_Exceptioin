package java_day23.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ApiMath_Test {
	// 유니크 ID 생성
	// ex) Guest20220318232154684 님 환영합니다.
	// 	   6자리의 랜덤 숫자를 이용해서 만들면 위험.
	
	// yyyyMMddHHmmssSSS + 랜덤수 6자리
	
	private static String resultDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
	}
	
	/**
	 * 유니크한 아이디 만들어주는 메소드
	 */
	public static String makeUniqueId() {
		Random rand = new Random();
		String result = "";
		for (int i = 0; i < 6; i++) {
			result += rand.nextInt(10);
		}
		result = resultDate("yyyyMMddHHmmssSSS") + result;
		return result;
	}
}
