package day15_Thread;

class A {
	public void start() {
		System.out.println("부모 start 실행");
		run();
	}
	
	public void run() {
		System.out.println("부모 run 실행");
	}
}

class B extends A {
	public void run() {
		System.out.println("자식 run 실행");
	}
}

class A02 extends Thread {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("A02 : " + i);
		}
	}
}

class B02 extends Thread {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("B02 : " + i);
		}
	}
}

public class Ex02 {

	public static void main(String[] args) {
		
		B b = new B();
		b.run();
		
		A02 aa = new A02();
		B02 bb = new B02();
		
		//프로그램이 종료될 때 thread도 종료시키는 메소드
		aa.setDaemon(true);
		bb.setDaemon(true);
		
		//thread start() -> ㅇ자식 클래스의 run() 실행
		aa.start();
		bb.start();
		
		System.out.println("프로그램을 종료합니다");
		System.out.println("프로그램을 종료합니다");
		System.out.println("프로그램을 종료합니다");
		
	}
}
