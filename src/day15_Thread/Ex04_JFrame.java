package day15_Thread;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex04_JFrame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("TEST");
		Container container = frame.getContentPane();	//장판
		JLabel label = new JLabel("Hello GUI");			//글씨
		
		container.add(label);
		
		//JFrame 사이즈와 위치 조정
		frame.setLocation(1000,200);					//JFrame 오픈되는 위치 세팅
		frame.setPreferredSize(new Dimension(500,200));	//창에 대한 사이즈
		frame.pack();									//변경사항 적용시키는 메소드
		
		//폰트 관련 수정
		Font font = new Font(null,Font.ITALIC,32);//글씨 폰트 관련 설정
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame.setVisible(true);							//셋팅한 프레임을 보여주는 메소드
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//↑창 끌 때 프로그램도 꺼주는 메소드
		
		for (int i=0; i<10; i++) {
		//label 메세지 수정
			label.setText(i + " : 안녕하세요 :)");
		}
	}
}
