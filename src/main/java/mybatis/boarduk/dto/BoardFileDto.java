package mybatis.boarduk.dto;

import lombok.Data;

@Data
public class BoardFileDto {
    private int fileId;
    private int boardNo;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
}