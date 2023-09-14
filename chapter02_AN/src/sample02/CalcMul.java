package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // 기본 생성자 지정
public class CalcMul implements Calc {
	//@Autowired  -> 빈(Bean) 즉, 객체로 잡고 넘어가기 때문에 기본형을 @Autowired하려면 빈부터 생성해야해서 복잡해진다. 지금은 걍 쓰지마라 
	// Setter메소드는 스프링 컨테이너가 해당 메서드가 빈을 주입받아야 하는 것으로 인식하기때문에 사용해도 상관x
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
