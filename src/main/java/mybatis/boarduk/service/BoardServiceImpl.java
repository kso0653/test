package mybatis.boarduk.service;

import lombok.extern.slf4j.Slf4j;
import mybatis.boarduk.dto.BoardDto;
import mybatis.boarduk.mapper.BoardMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    public BoardServiceImpl (BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
//        boardMapper.insertBoard(board);
        if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            String name;
            while(iterator.hasNext()) {
                name = iterator.next();
                log.debug("file tag name : " + name);
                List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
                for(MultipartFile multipartFile : list) {
                    log.debug("start file information");
                    log.debug("file name : " + multipartFile.getOriginalFilename());
                    log.debug("file size : " + multipartFile.getSize());
                    log.debug("file content type : " + multipartFile.getContentType());
                    log.debug("end file information.\n");
                }
            }
        }
    }

    @Override
    public BoardDto selectBoardDetail(int boardNo) throws Exception {
        boardMapper.updateViewCount(boardNo);
        int i = 10 / 0; // ADD 고의로 예외 발생 (트랜잭션 테스트)
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