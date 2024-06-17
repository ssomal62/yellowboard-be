package com.yellowstone.yellowboardbe.service.impl;

import com.yellowstone.yellowboardbe.dto.response.user.GetSignInUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
}
