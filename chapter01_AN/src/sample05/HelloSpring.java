package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample04.Calc;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		SungJuk sungjuk = (SungJuk)applicationContext.getBean("sungJukImpl");
		sungjuk.calc();
	}
}


/*
[문제] 성적계산
이름, 국어, 영어, 수학점수를 입력하여 총점과 평균을 구하여 출력하시오
- Scnner는 <bean> 으로 생성하는 것이 아니라 new 하면 된다.

Package  : sample05

Interface : SungJuk.java

추상메소드  : public void calc();
          public void display();

Class    : SungJukImpl.java - SungJuk를 Override하는 클래스
Field    : name, kor, eng, math, tot, avg
Method   : 기본 생성자 - Scanner 통해서 데이터 입력
          public void calc() - 총점, 평균 계산
          public void display() - 출력

Class    : HelloSpring.java - public static void main(String[] args)
            
[실행결과]
이름 입력 :
국어 입력 :
영어 입력 :
수학 입력 :           

이름		국어		영어		수학		총점		평균
홍길동		95			78			96			269			89.667
*/