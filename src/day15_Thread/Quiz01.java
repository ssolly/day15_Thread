package day15_Thread;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Timer extends Thread {

	private Date date;
	private SimpleDateFormat simpl;

	public void setDate(){
		date = new Date();
		simpl =	new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
	}
	
	public String getDate() {
		setDate();
		return simpl.format(date);
	}
	
	public String time() {
		setDate();
		//System.out.println(getDate());
		while (true) {
			setDate();
			getDate();
			try {
				Thread.sleep(1000);	//1/1000기준, ()시간만큼 대기 시켜준다
			} catch (Exception e) {
			}
		}
		
	}
	
	public void run() {
	JFrame frame = new JFrame("TEST");
	Container container = frame.getContentPane();	
	JLabel label = new JLabel(getDate());			
	
	container.add(label);
	
	//JFrame 사이즈와 위치 조정
	frame.setLocation(1000,200);					//JFrame 오픈되는 위치 세팅
	frame.setPreferredSize(new Dimension(500,200));	//창에 대한 사이즈
	frame.pack();									//변경사항 적용시키는 메소드
	
	//폰트 관련 수정
	Font font = new Font(null,0,25);//글씨 폰트 관련 설정
	label.setFont(font);
	label.setHorizontalAlignment(JLabel.CENTER);
	
	frame.setVisible(true);							//셋팅한 프레임을 보여주는 메소드
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	//↑창 끌 때 프로그램도 꺼주는 메소드
	
	for (;;) {
		setDate();                                      
		label.setText(getDate());
		try {
			Thread.sleep(1000);	//1/1000기준, ()시간만큼 대기 시켜준다
		} catch (Exception e) {
		}
	}
	
	}
}

class Timer_Proc {

	private Date date;
	private SimpleDateFormat simpl;

	public void setDate(){
		date = new Date();
		simpl =	new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
	}
	
	public String getDate() {
		return simpl.format(date);
	}
	
	public void time() {
		setDate();
		//System.out.println(getDate());
		
		for(int i=0;i<5;i++) {
			setDate();
			System.out.println(getDate());
			try {
				Thread.sleep(1000);	//1/1000기준, ()시간만큼 대기 시켜준다
			} catch (Exception e) {
			}
		}
	}
}

class Win7_Proc extends Timer_Proc {

	public int input() {
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.print("입력>>> ");
		input = sc.nextInt();
		return input;
	}
	
	public String useInput() {
		Scanner sc = new Scanner(System.in);
		String input;
		System.out.print("사용할 기능 입력>>> ");
		input = sc.next();
		return input;
	}
	
	public void clac() {
		System.out.println("calc.exe 동작 합니다");
		ProcessBuilder pro = new ProcessBuilder("calc");
		try {
			pro.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void notepad() {
		System.out.println("notepad.exe 동작 합니다");
		ProcessBuilder pro = new ProcessBuilder("notepad");
		try {
			pro.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void display() {
		while(true) {
			System.out.println("===== 환영합니다 =====");
			System.out.println("1. 기능");
			System.out.println("2. off");
			int choice = input();
			
			switch(choice) {
			case 1 :
				System.out.println("사용 가능 기능");
				System.out.println("1 : 계산기");
				System.out.println("2 : 메모장");
				String str = useInput();
				if (str.equals("계산기")) {
					clac();
				} else if (str.equals("메모장")) {
					notepad();
				} else {
					System.out.println("잘못된 입력입니다");
				}
				break;
				
			case 2:
				System.out.println("종료");
				return;
			}
		}
	}
	
}

class Login_Proc extends Win7_Proc  {
	private String id=null, pass=null;
	boolean flag=false;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String inputId() {
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.print("id 입력 : ");
		str = sc.next();
		return str;
	}
	
	public String inputPass() {
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.print("password 입력 : ");
		str = sc.next();
		return str;
	}
	
	public void login() {

		if(getId()==null) {
			flag=false;
			System.out.println("로그인 정보가 존재하지 않습니다");
		} else {
			getId();
			getPass();
			String id, pass;
			id = inputId();
			pass = inputPass();
			if (id.equals(getId()) && pass.equals(getPass())) {
				System.out.println("로그인 성공");
				flag=true;
				if (flag==true) {
					Timer timer = new Timer();
					timer.setDaemon(true);
					timer.start();
					
				}
				super.display();
			} else {
				flag=false;
				if (!id.equals(getId())) {
					System.out.println("로그인 실패 : 아이디가 같지 않습니다");
				} else if(!pass.equals(getPass())) {
					System.out.println("로그인 실패 : 비밀번호가 같지 않습니다");
				}
			}
		}
	}


	public void joinMember() {
		String id,pass;
		id = inputId();
		pass = inputPass();
		setId(id);
		setPass(pass);
		System.out.println(getId());
		System.out.println(getPass());
	}
}

public class Quiz01 {
	
	/*
	 # Quiz01의 내용을 Time클래스를 상속하여 실행하시오
	   ( Time 클래스 실행 후 로그인 프로그램 실행 인증 통과 후 win7 실행 )
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Login_Proc login = new Login_Proc();
		Timer time = new Timer();
	
		
		//time.time();
				
		login.time();
		
		while(true) {
			System.out.print("1.로그인  2.가입  3.로그아웃 \n>> ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1 :
				login.login();
				break;
			case 2 :
				login.joinMember();
				break;
			case 3 : 
				
				return;
			}
		}
	}
	
}
