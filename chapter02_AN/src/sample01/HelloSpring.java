package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean = applicationContext.getBean("messageBeanImpl", MessageBean.class);
		messageBean.sayHello();
		messageBean.sayHello("바나나", 2500); // xml을 통해 들어온다 할지라도 외부에서 인자로 값이 들어오면 그걸로 덮어씌움(즉, 먼저 처리함) (대신 인자값이 없는건 기존처럼 xml을 통해 들어옴)
		messageBean.sayHello("참외", 10000, 2);
	}
}
