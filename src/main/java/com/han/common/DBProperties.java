package com.han.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by high on 2017. 10. 26..
 */
/*
@ConfigurationProperties
아래 resources/application.properties
파일의 데이터를 읽어 오는 역할을 합니다.
prefix 를 설정해주면 그 이름으로 설정되어있는 데이터를 가져옵니다.
 */
@ConfigurationProperties(prefix = "mybatis")
public class DBProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String mapperLocation;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMapperLocation() {
        return mapperLocation;
    }

    public void setMapperLocation(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }
}