package mybatis.boarduk.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class BoardDto {
    private int boardNo;
    private String boardTitle;
    private String boardContents;
    private int boardViews;
    private String boardWriter;
    private LocalDateTime insertTimestamp;
    private String boardEditor;
    private LocalDateTime updatedTimestamp;
    private List<BoardFileDto> fileList;
}