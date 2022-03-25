package java_day25;

import java.util.Scanner;

public class TryWithResource {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// finally 에서 사용하는 close
		try {
			System.out.print("아무말이나 입력: ");
			System.out.println(sc.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		// try-with-resource 구문
		// 닫아야할 객체를 try() 괄호 안에 선언 후
		// try 블록{} 내에서 사용
		// 객체의 클래스는 AutoCloseable 인터페이스를 구현하고 있어야한다.
		try(Scanner sca = new Scanner(System.in)) {
			System.out.print("아무말이나 입력 두번째: ");
			System.out.println(sc.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// try-with-resource의 경우, catch를 붙이지 않아도 된다.
		try(Scanner sca = new Scanner(System.in)) {
			System.out.print("아무말이나 입력 세번째: ");
			System.out.println(sc.nextLine());
		}
		
		// try() 괄호 안에 객체 여러개 선언
		try(Scanner scan = new Scanner(System.in);
				Scanner scann = new Scanner(System.in)) {
			System.out.print("아무말이나 입력 네번째: ");
			System.out.println(sc.nextLine());
			System.out.print("아무말이나 입력 다섯번째: ");
			System.out.println(sc.nextLine());
		}
	}
}
