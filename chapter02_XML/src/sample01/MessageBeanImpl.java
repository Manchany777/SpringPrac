package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // 1.생성자 : 이게 있으면 생성자 필요x
public class MessageBeanImpl implements MessageBean {
	@NonNull // 1.생성자 : 생성자에 주입하는 필드 변수를 여기다 선언해야 함
	private String fruit;
	@Setter // 2.세터 :  이게 있으면 Setter 메소드 필요x
	private int qty;
	@Setter // 2.세터 :  필드명마다 일일이 잡아야 함
	private int cost;
	
	
//	public MessageBeanImpl(String fruit) {
//		super();
//		this.fruit = fruit;
//	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setQty(int qty) {
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
