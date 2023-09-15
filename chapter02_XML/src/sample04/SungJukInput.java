package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukInput implements SungJuk {
	@Setter
	private SungJukDTO2 sungJukDTO2;
	@Setter
	private List<SungJukDTO2> list;
	
	// SungJukInput은 생성자가 아닌 setter 방식으로 씀 (얘 대신에 lombok으로 썼음)
//	@Autowired
//	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
//		this.sungJukDTO2 = sungJukDTO2;
//	}
//	public void setList(List<SungJukDTO2> list) {
//		this.list = list;
//	}

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
