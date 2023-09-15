package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	@Autowired 
	// xml에선 setter로 잡아줬지만, 여기선 setter이건, 생성자이건 상관없이 SungJukDTO2를 자동으로 연결하게 함
	private SungJukDTO2 sungJukDTO2;
	
	@Autowired  // 알아서 자바의 ArrayList를 잡아줌
	@Qualifier("arrayList") // List의 어떤 자식객체를 사용할 건지 명시해주는 어노테이션 (그다지 쓸 일은 많지 않다.) - configuration에서 설정해준 값을 적어야 함
	private List<SungJukDTO2> list;
	// 인터페이스로 제공하면 어떤 타입을 달라는건지 모르기때문에 Autowired할 때 생성된 빈들 중에서 어떤 빈을 연결할 것인지
	// (SpringConfiguration.java 보면 Component뿐만 아니라 List도 있음) 명확하게 명시해야함
	// private ArrayList<SungJukDTO2> list; 이렇게 하면 안 된다.

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.print("이   름 입력 : ");
		String name = scan.next();
		System.out.print("국어점수 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scan.nextInt();	
		
		int tot = kor + eng + math;
		double avg = tot/3.;
		
		// SungJukDTO2 sungJukDTO2 = new SungJukDTO2(); => 이거 대신 빈으로 주입해야 함
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);

		
		// List<SungJukDTO2> list = new ArrayList<SungJukDTO2>(); => 이거 대신 빈으로 주입해야 함
		list.add(sungJukDTO2);
		System.out.println(list);
		
		System.out.println();
		System.out.println(name + "님의 데이터를 입력 하였습니다");
		System.out.println();
	}


}
