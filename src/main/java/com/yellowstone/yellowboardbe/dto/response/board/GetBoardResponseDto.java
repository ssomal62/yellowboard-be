package com.yellowstone.yellowboardbe.dto.response.board;

import com.yellowstone.yellowboardbe.dto.ResponseCode;
import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetBoardResponseDto extends ResponseDto {

    private int boardNumber;
    private String title;
    private String content;
    private List<String> boardImageList;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

    private GetBoardResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<GetBoardResponseDto> success() {
        GetBoardResponseDto result = new GetBoardResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        GetBoardResponseDto result = new GetBoardResponseDto();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
