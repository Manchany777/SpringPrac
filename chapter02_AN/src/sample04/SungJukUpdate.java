package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class SungJukUpdate implements SungJuk {
	@Autowired
	@Qualifier("arrayList") 
	private List<SungJukDTO2> list;

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		
		int sw=0;  // 같은 이름을 찾았는지 못찾았는지 구분하기 위한 스위치 변수
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				
				System.out.println("이름\t국어	\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2);
				
				System.out.println();
				
				System.out.println("국어점수 입력 : ");
				int kor = scan.nextInt();
				System.out.println("영어점수 입력 : ");
				int eng = scan.nextInt();
				System.out.println("수학점수 입력 : ");
				int math = scan.nextInt();
				System.out.println(sungJukDTO2.getName() + "님의 데이터를 수정 하였습니다");
				
				int tot = kor + eng + math;
				double avg = tot/3.;
				
				System.out.println();
				
				sungJukDTO2.setName(name);
				sungJukDTO2.setKor(kor);
				sungJukDTO2.setEng(eng);
				sungJukDTO2.setMath(math);
				sungJukDTO2.setTot(tot);
				sungJukDTO2.setAvg(avg);
				
				break;
			} // if
		}// for
		
		if(sw == 0) {
			System.out.println();
			System.out.println("찾고자 하는 이름이 없습니다.");
		} // if
	}
}
