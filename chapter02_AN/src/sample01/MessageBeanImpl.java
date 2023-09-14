package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component  // SpringConfiguration.java 파일이 있으면 이거 필요x
public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int qty;
	private int cost;
	
	// Constructor Injection
	public MessageBeanImpl(@Value("사과") String fruit) { // lombok을 import하면 x
		super();
		this.fruit = fruit;
	}
	
	// Setter Injection
	@Autowired  // 어노테이션 방식(@Component) 사용할 때
	public void setCost(@Value("5000") int cost) {
		this.cost = cost;
	}
	@Autowired
	public void setQty(@Value("3") int qty) {
		this.qty = qty;
	}


	
	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "\t" + qty);

	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "\t" + qty);
	}

}
