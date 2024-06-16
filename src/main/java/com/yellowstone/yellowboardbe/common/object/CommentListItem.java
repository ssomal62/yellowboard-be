package com.yellowstone.yellowboardbe.common.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentListItem {
    private String nickname;
    private String writeDatetime;
    private String profileImage;
    private String content;
}
