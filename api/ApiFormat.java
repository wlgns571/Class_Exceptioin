package java_day23.api;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class ApiFormat {
	public static void main(String[] args) {
		// 숫자 형식 DecimalFormat
		
		// 자리수에 맞춰 숫자 앞에 0 붙이기
		// 1이면 001, 11이면 011, 132면 132
		DecimalFormat deciFormat = new DecimalFormat("000");
		String strNum = deciFormat.format(1);
		System.out.println(strNum);
		System.out.println(deciFormat.format(11));
		System.out.println(deciFormat.format(132));
		
		System.out.println("\n=====================================\n");
		
		// 자리수에 맞춰 소수 뒤에 0 붙이기
		// 0.1 이면 0.100, 0.11이면 0.110, 0.132면 0.132
		deciFormat = new DecimalFormat("0.000");
		System.out.println(deciFormat.format(0.1));
		System.out.println(deciFormat.format(1.11));
		System.out.println(deciFormat.format(0.132));
		
		System.out.println("\n=====================================\n");
		
		// 소수 넷째자리에서 반올림
		// 3.141592 -> 3.142
		deciFormat = new DecimalFormat("#.###");
		System.out.println(deciFormat.format(0.141592));
		System.out.println(deciFormat.format(3.141592));
		
		// 정수 문자열을 정수(int)로 바꾸기 Integer.parseInt()
		// 실수 문자열을 실수(double)로 바꾸기 Double.parseDouble()
		double doubVal = Double.parseDouble("3.1415");
		System.out.println(doubVal);
		
		System.out.println("\n=====================================\n");
		
		// 천 단위마다 ,(콤마) 붙이기
		deciFormat = new DecimalFormat("#,###");
		System.out.println(deciFormat.format(1234567890));
		
		System.out.println("\n=====================================\n");
		
		// 문자 형식 MessageFormat
		String formatStr = "ID: {0}\n이름: {1}\n연락처: {2}";
		String result = MessageFormat.format(formatStr, "wlgns571", "김지빵", "01012345678");
		System.out.println(result);
		
		formatStr = "ID: %s\n이름: %s\n연락처: %s";
		System.out.printf(formatStr, "wlgns571", "김지빵", "01012345678");
		
		System.out.println();
		// 두 번재 방식
		formatStr = "ID: {0}\n이름: {1}\n연락처: {2}";
		Object[] arguments = {"wlgns571", "김지빵", "01012345678"};
		result = MessageFormat.format(formatStr, arguments);
		System.out.println(result);
	}
}
