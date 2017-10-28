package com.han.repositories;

import com.han.models.Board;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * Created by high on 2017. 10. 26..
 */
/*
resource/META-INF/mapper/ 경로에 있는 xml파일과 연결 해주기위한 곳이에요.
@Mapper 가 실질 적으로 그역할을 해줘요!
그리고 아래 메서드를 호출 하면 그쿼리를 실행시켜서
데이터를 가져오던지 데이터를 적재하는 역할을 합니다.
 */
@Mapper
public interface BoardMapper {
    public List<Board> list(Map<String, Object> param);
    public void add(Map<String, Object> param);
}
