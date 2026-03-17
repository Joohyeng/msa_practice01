package com.example.apiboardcommand;

import java.time.LocalDateTime;

public class BoardDto {
    public static class RegReq{
        private String title;
        private String content;

        public Board toEntity(){
            return Board.builder()
                    .title(this.title)
                    .content(this.content)
                    .createdAt(LocalDateTime.now())
                    .build();
        }
    }
}
