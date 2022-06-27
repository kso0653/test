package mybatis.boarduk.service;

import mybatis.boarduk.dto.BoardDto;
import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board) throws Exception;

    BoardDto selectBoardDetail(int boardNo) throws Exception;
}
