package sample04;

import java.util.Scanner;

public class SungJukInput implements SungJuk {
	Scanner scan = new Scanner(System.in);
	private SungJukDTO2 sungJukDTO2 = null;
	
	public SungJukInput(SungJukDTO2 sungJukDTO2) {
		super();
		this.sungJukDTO2 = sungJukDTO2;
	}

	public void calcTot() {
		sungJukDTO2.setTot(sungJukDTO2.getKor() + 
				sungJukDTO2.getEng() + sungJukDTO2.getMath());
	}

	public void calcAvg() {
		sungJukDTO2.setAvg((double)sungJukDTO2.getTot()/3.0);
	}

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
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		
		calcTot();
		calcAvg();
		
		System.out.println();
		System.out.println(sungJukDTO2.getName() + "님의 데이터를 입력 하였습니다");
		System.out.println();
	}
}
