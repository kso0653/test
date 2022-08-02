package mybatis.boarduk.service;

import mybatis.boarduk.dto.BoardDto;
import mybatis.boarduk.dto.BoardFileDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    BoardDto selectBoardDetail(int boardNo) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardNo) throws Exception;

    BoardFileDto selectBoardFileInformation(int fileId, int boardNo) throws Exception;

    void deleteBoardFile(int fileId, int boardNo) throws Exception;

    List<BoardDto> searchBoardList(String searchTitle) throws Exception;
}
