package com.han.controllers;

import com.han.models.Board;
import com.han.models.CommonResponse;
import com.han.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by high on 2017. 10. 26..
 */
/*
Controller는 클라이언트에서 request를 던졌을 때, 그 url에 따라 맞는 요청을 수행해주는 곳이에요.
일반적으로는 @Controller 라는 어노테이션을 사용하는데 이것은
단지 자바의 servletResponse 객체를 반환 해주는 반면
스프링 부트 에는 @RestController라는 것이 있습니다.
다른점은 단순히 servletResponse 객체를 반환 해주는 것이 아닌
response 데이터를 Json데이터로 변경하여 반환 해줍니당
 */
@RequestMapping("boards")
@RestController
public class BoardController {

    /*
    @Autowired는 스프링에 있는 기능인데, BoardService 객체를 처음 빌드할때 등록 하면 그것을 자동으로 연결해주는 역할을 합니다.
    일반적으로 객체를 사용할때 new 로 생성하지만 그렇게 했을대 가비지가 많이 남기 때문에 스프링은 메모리 관리를 위해
    처음에 객체를 생성해놓고 재사용을 합니다.
     */
    @Autowired private BoardService boardService;
    private final int pageSize = 10;

    /*
    @RequestMapping은 요청 받은 url을 설정 해주는 곳이에요.
    상단 클래스에 @RequestMapping("boards") 와
    메서드의 @RequestMapping( value = "/list/{page}", method = RequestMethod.GET) 가 조합되서
    아래 list 라는 메서드에 접근하려면
    도메인/boards/list/{페이지}
    로 요청하면 되요. 그러면 list 라는 메서드가 실행이 됩니다
    RequestMethod.GET은 restapi 종류 인데
    GET, POST, DELETE, PUT 등여러가지가 있는데 아직은 몰라도 괜찮습니다
     */

    @RequestMapping( value = "/list/{page}", method = RequestMethod.GET)
    public List<Board> list(@PathVariable("page") Integer page) {
        page = (page == null) ? 1 : page;
        int offset = (page - 1) * pageSize;
        return boardService.list(page, offset);
    }

    @RequestMapping( value = "/", method = RequestMethod.POST)
    public CommonResponse add(@RequestBody Board board) {
        if (board == null)
            return new CommonResponse(CommonResponse.fail, "board 값이 없습니다.");
        if (board.getTitle() == null)
            return new CommonResponse(CommonResponse.fail, "board 타이틀 값이 없습니다.");
        if (board.getContents() == null)
            return new CommonResponse(CommonResponse.fail, "board 내용이 없습니다.");
        return new CommonResponse(boardService.add(board));
    }

    /*
    연습
    업데이트 하는 api를 만들어 봐요~
     */
    @RequestMapping( value = "/", method = RequestMethod.PUT)
    public CommonResponse update(@RequestBody Board board) {
        return null;
    }

    /*
    여기까지 해보면 스프링에 Aop나 Interceptor를 찾아보는것도 도움될것 같아요
    인증이나 보안에 관련해서 많이 사용하고 있는 기능입니다.
    (사실 몰라도 괜찮긴해요)
     */
}
