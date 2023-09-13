package sample03;

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