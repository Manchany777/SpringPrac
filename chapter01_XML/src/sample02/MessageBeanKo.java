package sample02;

public class MessageBeanKo implements MessageBean{
	
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
}