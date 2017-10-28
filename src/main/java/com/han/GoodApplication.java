package com.han;

import com.han.common.DBProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/*
스프링게시판 서버 완벽 가이드 ㅋㅋㅋ
@SpringBootApplication이 실질적으로 스프링의 모든 설정을 담당해줘요
그래서 이 어노테이션이 붙어 있으면 여기서 제일 먼저 실행해! 라고 알려줍니당
코드를 보는 순서는
Controller -> service -> repository 순서로 보면 됩니다.
model은 위의 레이어간에 데이터를 이동시키기위해 사용합니다~
 */
@SpringBootApplication
@PropertySources(value = @PropertySource("classpath:application.properties"))
@EnableConfigurationProperties({DBProperties.class})
public class GoodApplication {

	/*
	자바 공부를 해보신분 이시라면 main에 staitc이 왜붙는지 고민해보는것도 좋을것 같아요!
	 */
	public static void main(String[] args) {
		SpringApplication.run(GoodApplication.class, args);
	}
}
