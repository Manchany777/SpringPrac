package sample04;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class SungJukInput implements SungJuk {
	Scanner scan = new Scanner(System.in);
	private SungJukDTO2 sungJukDTO2 = null;
	
	// input은 생성자가 아닌 setter 방식으로 씀
	@Autowired
	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
		this.sungJukDTO2 = sungJukDTO2;
	}

//	public void calcTot() {
//		int tot = sungJukDTO2.getKor() + 
//				sungJukDTO2.getEng() + sungJukDTO2.getMath();
//		sungJukDTO2.setTot(tot);
//	}
//
//	public void calcAvg() {
//		double avg = (double)(sungJukDTO2.getTot()/3.0);
//		sungJukDTO2.setAvg(avg);
//	}

	@Override
	public void execute() {
		
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
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		//calcTot();
		//calcAvg();
		
		System.out.println();
		System.out.println(sungJukDTO2.getName() + "님의 데이터를 입력 하였습니다");
		System.out.println();
	}
}
