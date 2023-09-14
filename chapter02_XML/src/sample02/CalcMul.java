package sample02;

import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 지정
public class CalcMul implements Calc {
	
	@Setter
	private int x;
	
	@Setter
	private int y;

	/*
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}*/
	
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x * y));
	}
}
