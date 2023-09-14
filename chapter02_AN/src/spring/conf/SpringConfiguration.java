package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;

// 'MessageBeanImpl를 빈으로 생성할 겁니다'라는 어노테이션(@Component)을 썼었다.
// 하지만 이제 어노테이션이 아니라 자바 파일에서 생성(new)시켜주려는 것이다
// 이 클래스는 일반 클래스가 아니라 bean을 설정할 수 있는 환경설정 파일입니다 하고 어노테이션을 걸어줘야 스프링이 읽어줄 수 있다.
// @Component라는 어노테이션을 쓰는 것처럼 자바 파일을 그대로 쓰는 방식

@Configuration
public class SpringConfiguration {
	
	// 빈 생성
	/*
	@Bean // 다른 방식과 달리 스프링은 이 new시킨 bean을 인식을 못하기때문에 따로 @Bean이라고 알려줘야 스프링과 연결이 된다.
	public MessageBeanImpl messageBeanImpl() { // 메소드명을 함수로 리턴되는 클래스에 대한 빈 아이디로 설정해줘야 함
		// 메소드명은 Component 규칙을 따라가기로 약속이 되어있다. (@Component("messageBeanImpl")와 @Component가 같듯이)
		return new MessageBeanImpl("사과");
	}*/
	
	@Bean(name="messageBeanImpl") // 자바 문법방식(getMessageBeanImpl)으로 쓰고 싶으면 Bean에 id name을 지정해줘야한다.
	public MessageBeanImpl getMessageBeanImpl() {
		return new MessageBeanImpl("사과");
	}
// applicationContext.xml 파일에 <context:component-scan base-package="spring.conf" /> 추가해야 정상동작함
}

/*
 @Bean
 - 메소드에서 return 되는 값을 스프링 빈으로 생성해준다.
 - 메소드의 이름은 반드시 빈의 id명으로 만들어야 한다.
 */
