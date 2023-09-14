package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 빈과 빈으로 생성된 애들은 스프링 컨테이너에 의해서 서로 연관관계를 맺게 된다.
public class SungJukImpl implements SungJuk {
	// 생성된 빈들중에서 SungJukDTO 찾아서 매핑을 해라
	// 생성자이건 Setter 메소드이건 상관없이 SungJukDTO 찾아서 매핑을 해라
	@Autowired
	private SungJukDTO sungJukDTO = null; // 필드, 초기화
	
	public SungJukImpl(SungJukDTO sungJukDTO) {
		super();
		this.sungJukDTO = sungJukDTO;
	}

	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor() + 
				sungJukDTO.getEng() + sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg((double)sungJukDTO.getTot()/3.0);
	}

	@Override
	public void display() {
		
		System.out.println("이름	국어	영어	수학	총점	평균");
		/*
		System.out.println(sungJukDTO.getName()+ "\t" 
					     + sungJukDTO.getKor()+ "\t" 
						 + sungJukDTO.getEng()+ "\t" 
						 + sungJukDTO.getMath() + "\t" 
						 + sungJukDTO.getTot() + "\t" 
						 + String.format("%.2f", sungJukDTO.getAvg()));
		*/
		System.out.println(sungJukDTO); // DTO에서 오버라이딩 했기때문에 주소값이 아닌 객체값이 나온다.
										// 위의 코드보다 훨씬 짧고 간결하게 출력이 가능
		System.out.println();
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();		
		System.out.println();
		
		sungJukDTO.setName(name);
		sungJukDTO.setKor(kor);
		sungJukDTO.setEng(eng);
		sungJukDTO.setMath(math);
		
		calcTot();
		calcAvg();
	}
}
