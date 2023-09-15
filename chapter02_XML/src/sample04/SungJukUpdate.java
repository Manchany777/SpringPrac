package sample04;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class SungJukUpdate implements SungJuk {
	Scanner scan = new Scanner(System.in);
	SungJukDTO2 sungJukDTO2 = null;
	SungJukInput sungJukInput = null;
	
	@Autowired
	public SungJukUpdate(SungJukDTO2 sungJukDTO2) {
		super();
		this.sungJukDTO2 = sungJukDTO2;
	}

	@Override
	public void execute() {
		
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
				
		if(sungJukDTO2.getName() != name) {
			System.out.println("찾고자하는 이름이 없습니다");
			System.out.println();
		} else {
			System.out.print("수정할 이름 입력 : ");
			name = scan.next();
			sungJukDTO2.getName();
			
			System.out.println("이름		국어		영어		수학		총점		평균");
			System.out.println(sungJukDTO2);
			System.out.println();
			
			System.out.println("국어점수 입력 : ");
			int kor = scan.nextInt();
			System.out.println("영어점수 입력 : ");
			int eng = scan.nextInt();
			System.out.println("수학점수 입력 : ");
			int math = scan.nextInt();
			System.out.println(sungJukDTO2.getName() + "님의 데이터를 수정 하였습니다");
	
			System.out.println();
			
			sungJukDTO2.setName(name);
			sungJukDTO2.setKor(kor);
			sungJukDTO2.setEng(eng);
			sungJukDTO2.setMath(math);
			
			//sungJukInput.calcTot();
			//sungJukInput.calcAvg();
		}

		
	}
}
