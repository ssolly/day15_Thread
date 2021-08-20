package day15_Thread;

import java.util.Scanner;

class A03 extends Thread {
	public void run() {
		while(true) {
			try {
				System.out.println("답글이 달렸습니다");
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}
		}
	}
}

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String message = null;
		A03 a = new A03();
		
		a.setDaemon(true);
		a.start();
		
		while(true) {
			System.out.print("전송 메세지 : ");
			message = sc.next();
			System.out.println(message);
			
			if (message.equals("exit")) {
				break;
			}
			System.out.println("프로그램을 종료 합니다");
			System.out.println("프로그램을 종료 합니다");
		}
	}
}
