package com.yellowstone.yellowboardbe.service;

import com.yellowstone.yellowboardbe.dto.request.auth.SignInRequestDto;
import com.yellowstone.yellowboardbe.dto.request.auth.SignUpRequestDto;
import com.yellowstone.yellowboardbe.dto.response.auth.SignInResponseDto;
import com.yellowstone.yellowboardbe.dto.response.auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

    //SignInResponseDto의 부모 형태 또한 모두 지네릭타입으로 받겠다는 의미
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

}
