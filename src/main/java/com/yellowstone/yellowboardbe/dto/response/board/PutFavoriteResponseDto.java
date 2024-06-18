package com.yellowstone.yellowboardbe.dto.response.board;

import com.yellowstone.yellowboardbe.dto.ResponseCode;
import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PutFavoriteResponseDto extends ResponseDto {

    private PutFavoriteResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PutFavoriteResponseDto> success() {
        PutFavoriteResponseDto result = new PutFavoriteResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
