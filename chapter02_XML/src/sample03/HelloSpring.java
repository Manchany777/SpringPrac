package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContextAdd = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJuk sungJuk = applicationContextAdd.getBean("sungJukImpl", SungJuk.class);
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display();
		
		sungJuk.modify(); // 수정
		sungJuk.display();
	}
}
