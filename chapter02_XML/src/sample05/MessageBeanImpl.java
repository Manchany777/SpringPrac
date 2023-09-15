package sample05;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private Outputter outputter;

	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl 기본 생성자");
	}
	
	public MessageBeanImpl(String name) {
		System.out.println("public MessageBeanImpl(String name)");
		this.name = name;
	}
	
	public void setPhone(String phone) {
		System.out.println("public void setPhone(String phone)");
		this.phone = phone;
	}
	
	public void setOutputter(Outputter outputter) {
		System.out.println("public void setOutputter(Outputter outputter)");
		this.outputter = outputter;
	}

	@Override
	public void helloCall() {
		System.out.println("public void helloCall()");
		outputter.output("나의 이름은 " + name + " 핸드폰은 " + phone);
		System.out.println();
	};
}
