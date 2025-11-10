package com.back;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WiseSaying {
    private int id;
    private LocalDateTime createDate;   // 명언이 생성된 날짜
    private LocalDateTime modifyDate;   // 명언이 가장 마지막에 수정된 날짜
    private String content;
    private String author;
    private static DateTimeFormatter forPrintDateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

    public WiseSaying(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNew() {
        return getId() == 0;
    }

    public String getForPrintCreateDate() {
        return createDate.format(forPrintDateTimeFormatter);
    }

    public String getForPrintModifyDate() {
        return modifyDate.format(forPrintDateTimeFormatter);
    }
}