package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // 기본 생성자 지정
public class CalcMul implements Calc {
	
	@NonNull
	//@Setter
	private int x;
	
	@NonNull
	//@Setter
	private int y;
	
	public CalcMul() {
		System.out.println("기본 생성자");
	}

	@Autowired
	public void setX(@Value("36") int x) {
		this.x = x;
	}
	@Autowired
	public void setY(@Value("15") int y) {
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x * y));
	}
}
