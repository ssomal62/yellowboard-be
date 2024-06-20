package com.yellowstone.yellowboardbe.service;

import com.yellowstone.yellowboardbe.dto.response.user.GetSignInUserResponseDto;
import com.yellowstone.yellowboardbe.dto.response.user.GetUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
}
