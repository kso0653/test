package mybatis.boarduk.controller;

import mybatis.boarduk.dto.BoardDto;
import mybatis.boarduk.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RestBoardApiController {

    private final BoardService boardService;

    @Autowired
    public RestBoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/api/board", method = RequestMethod.GET)
    public List<BoardDto> openBoardList() throws Exception {
        return boardService.selectBoardList();
    }

    @RequestMapping(value = "/api/board/write", method = RequestMethod.POST)
    public void insertBoard(@RequestBody BoardDto board) throws Exception {
        boardService.insertBoard(board, null);
    }

    @RequestMapping(value = "/api/board/{boardNo}", method = RequestMethod.GET)
    public BoardDto openBoardDetail(@PathVariable("boardNo") int boardNo) throws Exception {
        return boardService.selectBoardDetail(boardNo);
    }

    @RequestMapping(value = "/api/board/{boardNo}", method = RequestMethod.PUT)
    public String updateBoard(@RequestBody BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/api/board/{boardNo}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/board/{boardNo}")
    public String deleteBoard(@PathVariable("boardNo") int boardNo) throws Exception {
        boardService.deleteBoard(boardNo);
        return "redirect:/board";
    }

    @RequestMapping(value = {"/api/board/search/{searchTitle}", "/api/board/search"} , method = RequestMethod.GET)
    public List<BoardDto> searchBoard(@PathVariable(name = "searchTitle", required = false) String searchTitle) throws Exception {
        return boardService.searchBoardList(searchTitle);
    }
}