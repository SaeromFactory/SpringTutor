package com.watchers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.watchers.model.Board;
import com.watchers.repository.BoardMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class BoardService {
    @Autowired private BoardMapper boardMapper;
    //@Autowired private BoardService board;

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
//        param.put("use_yn", board.getUseYn());
        param.put("created_id", board.getCreatedId());
        boardMapper.add(param);
        return board;
    }

    public Board set(Board board) {
        Map<String, Object> param = new HashMap<>();
        param.put("id", board.getId());
        param.put("title", board.getTitle());
        param.put("contents", board.getContents());
//        param.put("use_yn", board.getUseYn());
//        param.put("updated_id", board.getUpdatedId());
        	boardMapper.set(param);
        param.put("created_id", board.getId());
        return board;
    }

    public Board del(Board board){
        Map<String, Object> param = new HashMap<>();
        param.put("idx", board.getIdx());
        boardMapper.del(param);
        //
        return board;
    }

    public Board view(int idx){
        Map<String, Object> param = new HashMap();
        param.put("idx", idx);
        Board board = boardMapper.view(param);
        return board;
    }

    public Board search_id(String id){
        Map<String, Object> param = new HashMap();
        param.put("id", id);
        Board board = boardMapper.search_id(param);
        return board;

    }


}
