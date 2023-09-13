package sample03;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class HelloSpring {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml"); 
		// ApplicationContext : 인터페이스라 직접적인 new가 안됨. new 가능한 자식클래스가 5개정도 됨
		
		MessageBean messageBean = (MessageBean)applicationContext.getBean("messageBean"); // bean값 읽어오기 
		// (클래스를 읽어오는 것이지만 접근은 항상 부모로 접근해야함), 이때 bean은 Object이므로 인터페이스 타입으로 캐스팅(형변환) 해야함
		messageBean.sayHello("Spring");
		
		MessageBean messageBean2 = (MessageBean)applicationContext.getBean("messageBean"); // bean값 읽어오기 
		messageBean2.sayHello("Spring");
		
		MessageBean messageBean3 = (MessageBean)applicationContext.getBean("messageBean"); // bean값 읽어오기 
		messageBean3.sayHello("Spring");
	}
}
