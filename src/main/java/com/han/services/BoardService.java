package com.han.services;

import com.han.models.Board;
import com.han.repositories.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by high on 2017. 10. 26..
 */
/*
이곳은 실제로 서비스의 로직을 처리하는 부분입니다.
트랜잭션 처리나 서비스에 필요한 데이터처리를 이곳에서 주로 담당합니다.
@Service는 처음에 빌드를 할때 스프링에 객체를 등록하기위해 사용합니다.
 */
@Service
public class BoardService {
    @Autowired private BoardMapper boardMapper;

    public List<Board> list(int pageSize, int offset) {
        Map<String, Object> param = new HashMap<>();
        param.put("size", pageSize);
        param.put("offset", offset);
        return boardMapper.list(param);
    }

    public Board add(Board board) {
        Map<String, Object> param = new HashMap<>();
        param.put("title", board.getTitle());
        param.put("contents", board.getContents());
        param.put("use_yn", board.getUseYn());
        param.put("created_at", Timestamp.valueOf(LocalDateTime.now()));
        param.put("created_id", board.getCreatedId());
        boardMapper.add(param);
        return board;
    }
}
