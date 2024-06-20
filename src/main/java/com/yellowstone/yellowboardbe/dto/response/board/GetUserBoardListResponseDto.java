package com.yellowstone.yellowboardbe.dto.response.board;

import com.yellowstone.yellowboardbe.common.object.BoardListItem;
import com.yellowstone.yellowboardbe.dto.ResponseCode;
import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.ResponseMessage;
import com.yellowstone.yellowboardbe.entity.BoardListViewEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetUserBoardListResponseDto extends ResponseDto {

    private List<BoardListItem> userBoardList;

    private GetUserBoardListResponseDto(List<BoardListViewEntity> boardListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userBoardList = BoardListItem.getList(boardListViewEntities);
    }

    public static ResponseEntity<GetUserBoardListResponseDto> success(List<BoardListViewEntity> boardListViewEntities) {
        GetUserBoardListResponseDto result = new GetUserBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
