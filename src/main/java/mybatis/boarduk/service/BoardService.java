package mybatis.boarduk.service;

import mybatis.boarduk.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    BoardDto selectBoardDetail(int boardNo) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardNo) throws Exception;
}
