package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		System.out.println("*** Life Cycle ***");
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean1 = (MessageBean)applicationContext1.getBean("messageBeanImpl2");
		messageBean1.helloCall();
		
//		ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Outputter outputter = (Outputter)applicationContext2.getBean("fileOutputter");
//		outputter.output(null);

	}
}