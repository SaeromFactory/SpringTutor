package com.watchers.repository;


import com.watchers.common.Mapper;
import com.watchers.model.Board;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Mapper
@Component
public interface BoardMapper {
    public List<Board> list(Map<String, Object> param);
    public void add(Map<String, Object> param);
    public void set(Map<String, Object> param);
    public void del(Map<String, Object> param);
    public Board view(Map<String, Object> param);
    public Board search_id(Map<String, Object> param);

}
