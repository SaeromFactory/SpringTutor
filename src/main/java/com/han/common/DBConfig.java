package com.han.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by high on 2017. 10. 26..
 */
/*
JSP를 배우셨던 분들은 JDBC설정을 해봤을꺼에요.
안해보셨어도 상관없습니다
스프링에서 다음과 같이 DB설정을 해줘요
Datasources - 디비의 접근정보
@MapperScan - 처음 빌드 시에 디비와 접근하는 인터페이스들을 스캔
sqlSessionFactory - DB 연결 설정 (DBCP 개념은 몰라도 되는데 궁금하시면 알려드릴게요)
@Configuartion - 스프링은 처음에 컨테이너에 객체를 등록해줄수 있는데
@Configuaration를 사용한 클래스 안의 @Bean을 사용해서 객체를 등록해줄수 있어요.
(이렇게 하는이유가 궁금하시면 알려드릴게요)
 */
@Configuration
@MapperScan(basePackages = { "com.han.repositories" }, sqlSessionFactoryRef = "SqlSessionFactory")
public class DBConfig {

    @Autowired
    private DBProperties dBProperties;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(dBProperties.getDriverClassName());
        dataSource.setUrl(dBProperties.getUrl());
        dataSource.setUsername(dBProperties.getUsername());
        dataSource.setPassword(dBProperties.getPassword());
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") javax.sql.DataSource dataSource,
                                               ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigurationProperties(mybatisProperties());
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(dBProperties.getMapperLocation()));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    private Properties mybatisProperties() {
        Properties properties = new Properties();
        properties.put("lazyLoadingEnabled", "true");
        return properties;
    }
}
