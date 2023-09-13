package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		// ※ ApplicationContext을 생성하는 여러가지 방법
		// 1. 파일 시스템 방식(new FileSystemXmlApplicationContext("src/applicationContext.xml"); )
		// 2. class path 방식(new ClassPathXmlApplicationContext("applicationContext.xml"); ) - 클래스의 기본위치가 src로 되어있기때문에 따로 src 적을 필요 x
		// 3. 제네릭 방식(new GenericXmlApplicationContext("classpath:applicationContext.xml");)
		// 4. 그외
		
		Calc calcAdd = (Calc)applicationContext.getBean("calcAddBean");
		calcAdd.calculate(25, 36);
		
		// 형변환 하지 않고 아예 bean id 옆에다 기술하는 방식으로 해도 됨
		Calc calcMul = applicationContext.getBean("calcMulBean", Calc.class);
		calcMul.calculate(25, 36);
	}
}
