package sample04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukDTO2 {
	// 생성된 빈들 중에서 생성자이건 Setter 메소드이건 상관없이 SungJukDTO2를 찾아서 매핑을 해라
	// SungJukInput 등에서 이 DTO를 쓰려면 @Autowired 하면 된다.
	private String name; 
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}
	
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + 
			   eng + "\t" + math + "\t" + 
			   tot + "\t" + String.format("%.2f", avg);
	}
}
