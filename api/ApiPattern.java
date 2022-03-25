package java_day23.api;

import java.util.regex.Pattern;

public class ApiPattern {
	public static void main(String[] args) {
		// 정규표현식 (Regular Expression)
		// 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰는 형식
		// 전화번호, 주민등록번호, 이메일 등과 같이 정해진 형식에 대해
		// 정규표현식 + Pattern을 이용하여 검증 할 수 있다.
		
		// 숫자만 존재하는지 검증
		String regex = "[0-9]*";
		String input = "123432";
		boolean result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		// 숫자 검증 두번째
		regex = "\\d*";
		input = "123456789";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		System.out.println("\n=============================\n");
		
		// 알파벳만 존재하는지 검증
		regex = "[a-zA-Z]*";
		input = "Kim JiHoon"; // 띄어쓰기가 있으면 안됨
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		// 띄어쓰기 포함
		regex = "[a-zA-z ]*";
		regex = "[a-zA-z\\s]*"; // 정석대로면 공백을 나타내는 \\s 넣음
		input = "Kim Ji Hoon";  
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		System.out.println("\n=============================\n");
		
		// 한글로만 존재하는지 검증
		regex = "[가-힣 ]*";
		regex = "[가-힣\\s]*";
		input = "김 지 훈";  
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		System.out.println("\n=============================\n");
		
		// 비밀번호 패턴
		// 영어와 숫자로만 구성
		regex = "[a-zA-Z\\d]*";
		regex = "\\w*";
		input = "Wlgns571";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		// 영어와 숫자 + 특수문자(필수 아님)
		regex = "[\\w!@#$%^&*)(-=_+`~]*";
		input = "NextIt28850!@#&($*";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		// 숫자, 영어 소문자 및 대문자, 특수문자가 각각 1개 이상
		// 포함되며, 비밀번호 자리가 8 ~ 20 자리 인지
		regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";//  보류
		input = "NextIt1234!";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		regex = "[0-9]+.{6,10}";
		input = "1234567";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		// 6자리 숫자 비밀번호 중 3자리 이상 반복 금지
		regex = "^.*(\\d)\\1\\1.*$";
		input = "122234";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		regex = "[\\d]{6}";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		System.out.println("\n=============================\n");
		
		// 이메일 형식 확인
		regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
		input = "wlgns571@gmail.com";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
		
		// 연락처 번호 형식 확인
		regex = "^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$";
		input = "010-3055-8832";
		result = Pattern.matches(regex, input);
		System.out.println(input + ", " + regex + " 결과 = " + result);
	}
}
