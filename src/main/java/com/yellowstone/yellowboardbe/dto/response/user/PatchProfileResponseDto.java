package com.yellowstone.yellowboardbe.dto.response.user;

import com.yellowstone.yellowboardbe.dto.ResponseCode;
import com.yellowstone.yellowboardbe.dto.ResponseDto;
import com.yellowstone.yellowboardbe.dto.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PatchProfileResponseDto extends ResponseDto {
    private PatchProfileResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PatchProfileResponseDto> success() {
        PatchProfileResponseDto result = new PatchProfileResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}

