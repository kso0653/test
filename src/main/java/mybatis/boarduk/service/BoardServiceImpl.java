package mybatis.boarduk.service;

import mybatis.boarduk.dto.BoardDto;
import mybatis.boarduk.mapper.BoardMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl (BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board) throws Exception {
        boardMapper.insertBoard(board);
    }

    @Override
    public BoardDto selectBoardDetail(int boardNo) throws Exception {
        boardMapper.updateViewCount(boardNo);
        BoardDto board = boardMapper.selectBoardDetail(boardNo);
        return board;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);
    }


    @Override
    public void deleteBoard(int boardNo) throws Exception {
        boardMapper.deleteBoard(boardNo);
    }
}