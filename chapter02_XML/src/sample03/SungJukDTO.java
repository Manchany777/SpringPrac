package sample03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SungJukDTO {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	@Override  // 16진수로 주소값(레퍼런스)로 나오는게 싫어서 오버라이딩함
	public String toString() {
		return name + "\t"  + kor + "\t" + eng + "\t" + 
				math + "\t" + tot + "\t" + 
				String.format("%.2f", avg);
	}
}
