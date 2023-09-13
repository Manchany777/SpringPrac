package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageBean")
@Scope("prototype") // 기본 설정인 싱글톤이 아니면 따로 선언해야함
public class MessageBeanKo implements MessageBean{
	private int num; // 필드, 초기화
	
	public MessageBeanKo() {
		System.out.println("기본 생성자");
	}
	
	@Override
	public void sayHello(String name) {
		num++;
		
		System.out.println("num = " + num);
		System.out.println("Hello " + name);
	}
}