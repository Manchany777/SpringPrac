package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContextAdd = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc1 = applicationContextAdd.getBean("calcAdd", CalcAdd.class);
		calc1.calculate();
		
		ApplicationContext applicationContextMul = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc2 = (Calc) applicationContextMul.getBean("calcMul");
		calc2.calculate();
	}
}
