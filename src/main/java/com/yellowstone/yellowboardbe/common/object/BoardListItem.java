package com.yellowstone.yellowboardbe.common.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListItem {
    private int boardNumber;
    private String title;
    private String content;
    private String boardTitleImage;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private String writeDatetime;
    private String writerNickName;
    private String writerProfileImage;
}
