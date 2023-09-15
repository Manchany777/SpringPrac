package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calc calc = applicationContext.getBean("calcAdd", Calc.class);
		calc.calculate();

        calc = applicationContext.getBean("calcMul", Calc.class);
        calc.calculate();
        
//		Calc calc1 = applicationContextAdd.getBean("calcAdd", CalcAdd.class);
//		calc1.calculate();
//		
//		ApplicationContext applicationContextMul = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Calc calc2 = (Calc) applicationContextMul.getBean("calcMul");
//		calc2.calculate();
	}
}