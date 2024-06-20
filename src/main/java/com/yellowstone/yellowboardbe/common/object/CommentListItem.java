package com.yellowstone.yellowboardbe.common.object;

import com.yellowstone.yellowboardbe.repository.resultSet.GetCommentListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListItem {
    private String nickname;
    private String writeDatetime;
    private String profileImage;
    private String content;

    public CommentListItem(GetCommentListResultSet resultSet) {
        this.nickname = resultSet.getNickname();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.profileImage = resultSet.getProfileImage();
        this.content = resultSet.getContent();
    }
    public static List<CommentListItem> copyList(List<GetCommentListResultSet> resultSets) {
        List<CommentListItem> list = new ArrayList<>();
        for(GetCommentListResultSet resultSet: resultSets) {
            CommentListItem commentListItem = new CommentListItem(resultSet);
            list.add(commentListItem);
        }

        return list;
    }
}
