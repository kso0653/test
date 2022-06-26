package mybatis.boarduk.domain;

import lombok.Data;

@Data
public class Board {
    private int boardNo;
    private String boardWriter;
    private String boardTitle;
    private String boardContents;
    private int boardViews;
}
