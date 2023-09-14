package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc1 = applicationContext1.getBean("calcAdd", CalcAdd.class);
		calc1.calculate();
		
		ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc2 = applicationContext2.getBean("calcMul", CalcMul.class);
		calc2.calculate();
	}
}
