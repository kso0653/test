package mybatis.boarduk.mapper;
import java.util.List;

import mybatis.boarduk.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;
    //인터페이스는 메소드의 이름과 반환형식만 지정
    //메소드 이름은 sql 이름(xml - select id)과 동일해야함
    void insertBoard(BoardDto board) throws Exception;
    BoardDto selectBoardDetail(int boardNo) throws Exception;
    void updateViewCount(int boardNo) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardNo) throws Exception;
}