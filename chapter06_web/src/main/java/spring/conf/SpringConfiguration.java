package spring.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:spring/db.properties") // (복수형이면 @PropertySources로 사용)
//@EnableTransactionManagement // Transaction 설정 - 여기다 쓰거나 xml에다 쓰거나 둘 중 하나만 해야함
public class SpringConfiguration {
	// 3번 방식
	@Value("${jdbc.driver}") // 변수에 Value(초기값) 입력 - 주의) import시 spring로 해야함 lombok 아님
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	// dataSource 빈 설정
	@Bean    // 리턴타입        메소드명
	public BasicDataSource dataSource() {  // 메소드()명은 리턴클래스의 아이디명으로 해줘야함(일종의 약속)
		// 3번방식 (2번 방식인 네임스페이스 방식은 여기서 쓸 필요x)
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		
		return basicDataSource;
		//     빈으로 생성할 리턴값 (메소드에서 생성(new)하는 얘를 빈으로 생성함)
	}
	// xml의 <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource"> 와 동일
	
	// sqlSessionFactory 빈 설정
	/*
	@Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);  // <property name="dataSource" ref="dataSource" />의 name값을 다시 setter로 복구
        sessionFactory.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:user/dao/userMapper.xml"));
        return sessionFactory;
    }*/
	// 쌤님 버전
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());  // <property name="dataSource" ref="dataSource" />의 name값을 다시 setter로 복구
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));  // 이것도 마찬가지로 다시 setter로 복구
        //sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"));
        /*
        sqlSessionFactoryBean.setMapperLocations(
        			new ClassPathResource("user/dao/userMapper.xml"),
        			new ClassPathResource("user/dao/userUploadMapper.xml"));*/
        
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("ㅊclasspath:*/dao/*Mapper.xml"));
        // user가 됐던 userupload가 됐던 끝에가 Mapper로 끝나면 다 잡아와라
        
        // setConfigLocation메소드에는 "classpath:spring/mybatis-config.xml" 사용 불가능
        // why? String타입으로 받는게 없어서. so, Resource타입으로 받아야 한다.
        // * 참고) ClassPath라는 Resource가 이미 class를 포함하기때문에 경로만 적어주면 된다.
        // * Resource란? :(프로젝트를 수행하기 위한) 자원 - xml, properties 등
        // * 참고)new ClassPathResource의 ClassPathResource는 하나밖에 지정이 안된다. 
        //      복수의 클래스패스를 지정할 때에는? 인터넷에서 찾아봐야 함
        //      반면에 setMapperLocations는 복수형이라  여러개의 Mapper Source 사용 가능
       
        return sqlSessionFactoryBean.getObject();
    }
	
	// SqlSession 빈 설정
	/*
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory.getObject());
    }*/
    // 쌤님 버전
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
    	SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
    	return sqlSessionTemplate;
    }
    
    // Transaction 빈 설정
    /*
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    } */
    // 쌤님 버전
    @Bean
    public DataSourceTransactionManager transactionManager() {
    	DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
    	return dataSourceTransactionManager;
    }
 
}