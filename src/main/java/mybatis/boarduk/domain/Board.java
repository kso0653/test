package mybatis.boarduk.domain;

import lombok.Data;

@Data
public class Board {
    private int boardNo;
    private String writer;
    private String title;
    private String contents;
    private int views;
}
