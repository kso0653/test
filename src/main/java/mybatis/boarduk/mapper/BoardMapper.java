package mybatis.boarduk.mapper;

import mybatis.boarduk.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int boardCount();

    List<Board> findAll();
}
