package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:spring/db.properties") // (복수형이면 @PropertySources로 사용)
public class SpringConfiguration {
	// 3번 방식
	@Value("${jdbc.driver}") // 변수에 Value(초기값) 입력 - 주의) import시 spring로 해야함 lombok 아님
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;
	
	@Bean
	public BasicDataSource dataSource() {  // 메소드()명은 리턴클래스의 아이디명으로 해줘야함(일종의 약속)
		//return new BasicDataSource();
		
		// 1번 상식
		// 위의 코드를 setter소스인 property를 쓰기 위해 아래처럼 바꾼다.
		/*
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@Localhost:1521:xe");
		basicDataSource.setUsername("c##java");
		basicDataSource.setPassword("1234");
		*/
		
		// 3번방식 (2번 방식인 네임스페이스 방식은 여기서 쓸 필요x)
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
		
	}
	// xml의 <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource"> 와 동일
}
