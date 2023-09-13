package sample04;

import org.springframework.stereotype.Component;

@Component("calcAddBean") 
//@Component  // 스프링이 bean의 설정을 알기때문에 이렇게만 써도 인식이 된다.
public class CalcAdd implements Calc {

	@Override
	public void calculate(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x + y));
	}
}
