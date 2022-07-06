package mybatis.boarduk.service;

import lombok.extern.slf4j.Slf4j;
import mybatis.boarduk.common.FileUtils;
import mybatis.boarduk.dto.BoardDto;
import mybatis.boarduk.dto.BoardFileDto;
import mybatis.boarduk.mapper.BoardMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
//@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final FileUtils fileUtils;

    @Autowired
    public BoardServiceImpl (BoardMapper boardMapper, FileUtils fileUtils) {
        this.boardMapper = boardMapper;
        this.fileUtils = fileUtils;
    }

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardMapper.insertBoard(board);
        List<BoardFileDto> list = fileUtils.parseFileInfo(board.getBoardNo(), multipartHttpServletRequest);
        if(CollectionUtils.isEmpty(list) == false) {
            boardMapper.insertBoardFileList(list);
        }
    }

    @Override
    public BoardDto selectBoardDetail(int boardNo) throws Exception {
        //        int i = 10 / 0; // ADD 고의로 예외 발생 (트랜잭션 테스트)
        BoardDto board = boardMapper.selectBoardDetail(boardNo);
        List<BoardFileDto> fileList = boardMapper.selectBoardFileList(boardNo);
        board.setFileList(fileList);

        boardMapper.updateViewCount(boardNo);

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

    @Override
    public BoardFileDto selectBoardFileInformation(int fileId, int boardNo) throws Exception {
        return boardMapper.selectBoardFileInformation(fileId, boardNo);
    }

    @Override
    public void deleteBoardFile(int fileId, int boardNo) throws Exception {
        boardMapper.deleteBoardFile(fileId, boardNo);
    }
}