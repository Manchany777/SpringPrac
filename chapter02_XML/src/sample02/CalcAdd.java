package sample02;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // @NonNull을 사용해서 생성자 필드 명시적으로 지정
public class CalcAdd implements Calc {
	// @NonNull을 사용할 때 주의해야 할 점 : 
	// @NonNull 어노테이션은 참조 타입 필드(Object, String 등)와 매개변수에만 사용해야 하며, 
	// 원시 자료형(int, double 등)에는 적용할 수 없다. 
	// 해당 필드 또는 매개변수가 null이 아니어야 함을 나타내는 어노테이션이기 때문이다. 
	// 즉, 이 어노테이션은 참조 타입에 대해서만 의미가 있다.
	
	@NonNull
	@Setter
	private int x;
	
	@NonNull
	@Setter
	private int y;
	
	/*
	public CalcAdd(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}*/
	
	/*
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}*/
	
	@Override
	public void calculate() {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
}
