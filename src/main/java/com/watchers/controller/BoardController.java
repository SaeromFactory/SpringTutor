package com.watchers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

import com.watchers.model.Board;
import com.watchers.model.CommonResponse;
import com.watchers.service.BoardService;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.watchers.model.Board.*;

@RequestMapping("boards")
@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    private final int pageSize = 10;

    @RequestMapping( value = "/list/{page}", method = RequestMethod.GET)
    public List<Board> list(@PathVariable("page") Integer page) {
        page = (page == null) ? 1 : page;
        int offset = (page - 1) * pageSize;
        return boardService.list(page, offset);
    }


    @RequestMapping( value = "/", method = RequestMethod.POST)
    public CommonResponse add(@RequestBody Board board, HttpSession session) {
        if (board == null)
            return new CommonResponse(CommonResponse.fail, "board 값이 없습니다.");
        if (board.getTitle() == null)
            return new CommonResponse(CommonResponse.fail, "board 타이틀 값이 없습니다.");
        if (board.getContents() == null)
            return new CommonResponse(CommonResponse.fail, "board 내용이 없습니다.");

        String writer = (String)session.getAttribute("id");
        board.setId(writer);
        return new CommonResponse(boardService.add(board));
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT)
    public CommonResponse update(@PathVariable("id") String id, @RequestBody Board board) {
        if(id == null)
            return new CommonResponse(CommonResponse.fail, "id가 없습니다.");
        if (board == null)
            return new CommonResponse(CommonResponse.fail, "board 값이 없습니다.");
        if (board.getTitle() == null)
            return new CommonResponse(CommonResponse.fail, "board 타이틀 값이 없습니다.");
        if (board.getContents() == null)
            return new CommonResponse(CommonResponse.fail, "board 내용이 없습니다.");

        board.setId(id);
        return new CommonResponse(boardService.set(board));
    }

    @RequestMapping(value ="/{idx}", method = RequestMethod.GET)
    public Board viewBoard(@PathVariable("idx") int idx){
        Board board = boardService.view(idx);
        if(board ==null){
            // 게시글 없을 때 에러 처리
        }
        return board;
    }

    @RequestMapping(value="/del/{idx}", method=RequestMethod.GET)
    public String delBoard(@RequestParam(value="idx") Board idx){
        boardService.del(idx);
        return "redirect:/list/{page}";
    }

    @RequestMapping(value="/search/{id}/", method=RequestMethod.GET)
    public Board searchId(@RequestParam(value="id") String id){
        Board board = boardService.search_id(id);
        return board;
        // 클라이언트에게 보여줄 값

    }

}
