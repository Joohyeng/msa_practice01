package com.example.apiboardquery;

import lombok.Getter;

public class BoardDto {
    @Getter
    public static class RegRes {
        private Long idx;
        private String title;
        private String content;

        public Board toDocument() {
            return Board.builder()
                    .idx(this.idx)
                    .title(this.title)
                    .content(this.content)
                    .build();
        }
    }
}