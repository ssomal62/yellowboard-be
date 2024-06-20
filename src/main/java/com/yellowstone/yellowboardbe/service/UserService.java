package com.yellowstone.yellowboardbe.service;

import com.yellowstone.yellowboardbe.dto.response.user.GetSignInUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
}
