package day15_Thread;

class A01 {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("A01 : " + i);
		}
	}
}

class B01 {
	public void run() {
		for (int i=0; i<100; i++) {
			System.out.println("B01 : " + i);
		}
	}
}

public class Ex01 {

	/*
	 # Thread(스레드)
	  : 프로그램을 동작시키기 위한 최소 단위
	  - 동작중인 프로그램을 process라고 한다
	  
	 */
	public static void main(String[] args) {
		
		//thread가 한개일 때 동작 : 한 번에 한 가지 일만 실행
		A01 a = new A01();
		B01 b = new B01();
		a.run();
		b.run();
		
		
	}
}
