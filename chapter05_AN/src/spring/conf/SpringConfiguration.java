package spring.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

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
	
	// dataSource 빈 설정
	@Bean
	public BasicDataSource dataSource() {  // 메소드()명은 리턴클래스의 아이디명으로 해줘야함(일종의 약속)
		// 3번방식 (2번 방식인 네임스페이스 방식은 여기서 쓸 필요x)
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
		
	}
	// xml의 <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource"> 와 동일
	
	// sqlSessionFactory 빈 설정
	@Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:user/dao/userMapper.xml"));
        return sessionFactory;
    }
	
	// SqlSession 빈 설정
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory.getObject());
    }
    
    // Transaction 빈 설정
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
 
}